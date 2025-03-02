package dev.dtgaeh.workfromhere.spaces.controller;

import dev.dtgaeh.workfromhere.spaces.model.SpaceResource;
import dev.dtgaeh.workfromhere.spaces.service.SpaceResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
public class SpaceResourceController {

    private static final String SPACES_BASE_PATH = "api/v1/spaces";

    private final SpaceResourceService spaceResourceService;

    public SpaceResourceController(SpaceResourceService spaceResourceService) {
        this.spaceResourceService = spaceResourceService;
    }

    @GetMapping(value = SPACES_BASE_PATH)
    public ResponseEntity<List<SpaceResource>> getAllSpaces() {

        return ResponseEntity.ok(spaceResourceService.getAllSpaces());
    }

    @GetMapping(value = SPACES_BASE_PATH + "/{id}")
    public ResponseEntity<SpaceResource> getSpaceById(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(spaceResourceService.getSpaceById(id));
    }

    @PostMapping(value = SPACES_BASE_PATH)
    public ResponseEntity<SpaceResource> createSpace(@RequestBody SpaceResource spaceResource) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .build(spaceResource.getId());

        return ResponseEntity.created(location).body(spaceResourceService.createSpace());
    }

    @PutMapping(value = SPACES_BASE_PATH + "{/id}")
    public ResponseEntity<SpaceResource> updateSpace(@PathVariable("id") Integer id, @RequestBody SpaceResource modifiedSpaceResource) {
        SpaceResource origionalSpaceResource = spaceResourceService.getSpaceById(id);

        if (origionalSpaceResource != null) {
            spaceResourceService.updateSpace(id, modifiedSpaceResource);
        }

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = SPACES_BASE_PATH + "{/id}")
    public ResponseEntity<Void> deleteSpace(@PathVariable("id") Integer id) {
        SpaceResource spaceResource = spaceResourceService.getSpaceById(id);

        if (spaceResource != null) {
            spaceResourceSerivce.deleteSpaceById(id);
        }

        return ResponseEntity.noContent().build();
    }

}

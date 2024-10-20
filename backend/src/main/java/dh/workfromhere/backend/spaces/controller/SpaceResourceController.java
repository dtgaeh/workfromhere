package dh.workfromhere.backend.spaces.controller;

import dh.workfromhere.backend.spaces.model.SpaceResource;
import dh.workfromhere.backend.spaces.service.SpaceResourceService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpaceResourceController {

    private static final String BASE_URL = "/api/v1/spaces/";

    private final SpaceResourceService spaceResourceService;

    public SpaceResourceController(SpaceResourceService spaceResourceService) {
        this.spaceResourceService = spaceResourceService;
    }

    @GetMapping(BASE_URL)
    public ResponseEntity<List<SpaceResource>> getAllSpaces() {
        return ResponseEntity.ok().body(spaceResourceService.getAllSpaces());
    }

    @GetMapping(BASE_URL + "{id}")
    public ResponseEntity<SpaceResource> getSpaceById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(spaceResourceService.getSpaceById(id));
    }

    @PostMapping(BASE_URL)
    public ResponseEntity<SpaceResource> createSpace(@RequestBody SpaceResource spaceResource) {
       return ResponseEntity.status(HttpStatus.CREATED).body(spaceResourceService.createSpace(spaceResource));
    }

    @PutMapping(BASE_URL + "{id}")
    public ResponseEntity<Void> updateSpace(
            @PathVariable Integer id,
            @RequestBody SpaceResource upDatedSpaceResource)
    {
        spaceResourceService.updateSpace(id,upDatedSpaceResource);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteSpace(@PathVariable Integer id) {
        spaceResourceService.deleteSpaceById(id);

        return ResponseEntity.noContent().build();
    }
}

package dev.dtgaeh.workfromhere.spaces.service;

import dev.dtgaeh.workfromhere.spaces.model.SpaceResource;
import dev.dtgaeh.workfromhere.spaces.repository.SpaceResourceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceResourceService {

    private final SpaceResourceRepository spaceResourceRepository;

    public SpaceResourceService(SpaceResourceRepository spaceResourceRepository) {
        this.spaceResourceRepository = spaceResourceRepository;
    }

    public List<SpaceResource> getAllSpaces() {

        return spaceResourceRepository.findAll();
    }

    public SpaceResource getSpaceById(Integer id) {
        return spaceResourceRepository.findById(id).orElse(null);
    }

    public SpaceResource createSpace(SpaceResource spaceResource) {
        return spaceResourceRepository.save(spaceResource);
    }

    @Transactional
    public void updateSpace(Integer id, SpaceResource modifiedSpaceResource) {
        spaceResourceRepository.findById(id).ifPresent(spaceResource -> modifySpace(modifiedSpaceResource, spaceResource));

    }

    public void deleteSpaceById(Integer id) {
        spaceResourceRepository.findById(id).ifPresent(spaceResourceRepository::delete);

    }

    private void modifySpace(SpaceResource modifiedSpaceResource, SpaceResource spaceResource) {

        spaceResource.setName(modifiedSpaceResource.getName());
        spaceResource.setDescription(modifiedSpaceResource.getDescription());
        spaceResource.setType(spaceResource.getType());
        spaceResource.setWifiAvailable(modifiedSpaceResource.isWifiAvailable());
        spaceResource.setWifiPassword(modifiedSpaceResource.getWifiPassword());
        spaceResource.setWifiSpeed(spaceResource.getWifiSpeed());

        spaceResourceRepository.save(spaceResource);
    }
}

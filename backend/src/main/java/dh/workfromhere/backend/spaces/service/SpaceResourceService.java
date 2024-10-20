package dh.workfromhere.backend.spaces.service;

import dh.workfromhere.backend.spaces.model.SpaceResource;
import dh.workfromhere.backend.spaces.repository.SpaceResourceRepository;
import java.util.List;
import org.springframework.stereotype.Service;


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

    public void updateSpace(Integer id, SpaceResource spaceResource) {
        SpaceResource spaceResourceToUpdate = spaceResourceRepository.findById(id).orElse(null);

        if (spaceResourceToUpdate != null) {
            UpdateSpaceResource(spaceResource, spaceResourceToUpdate);
        }
    }

    public void deleteSpaceById(Integer id) {
        SpaceResource spaceResourceToDelete = spaceResourceRepository.findById(id).orElse(null);

        if (spaceResourceToDelete != null) {
            spaceResourceRepository.delete(spaceResourceToDelete);
        }
    }

    // TODO - Validation Methods

    private void UpdateSpaceResource(SpaceResource origonalSpaceResource, SpaceResource newSpaceResource) {
        origonalSpaceResource.setName(newSpaceResource.getName());
        origonalSpaceResource.setDescription(newSpaceResource.getDescription());
        origonalSpaceResource.setWifiAvailable(newSpaceResource.getWifiAvailable());
        origonalSpaceResource.setWifiPassword(newSpaceResource.getWifiPassword());
        origonalSpaceResource.setWifiSpeed(newSpaceResource.getWifiSpeed());
        spaceResourceRepository.save(origonalSpaceResource);
    }
}

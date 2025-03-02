package dev.dtgaeh.workfromhere.spaces.service;

import dev.dtgaeh.workfromhere.spaces.repository.SpaceResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class SpaceResourceService {

    private final SpaceResourceRepository spaceResourceRepository;

    public SpaceResourceService(SpaceResourceRepository spaceResourceRepository) {
        this.spaceResourceRepository = spaceResourceRepository;
    }
}

package dev.dtgaeh.workfromhere.users.service;

import dev.dtgaeh.workfromhere.users.dto.UserResourceDTO;
import dev.dtgaeh.workfromhere.users.exception.UserResourceException;
import dev.dtgaeh.workfromhere.users.model.UserResource;
import dev.dtgaeh.workfromhere.users.model.UserRoleResource;
import dev.dtgaeh.workfromhere.users.repository.UserResourceRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserResourceService {

    private final UserResourceRepository userResourceRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResourceService(UserResourceRepository userResourceRepository, PasswordEncoder passwordEncoder) {
        this.userResourceRepository = userResourceRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserResourceDTO userResourceDTO) {
        doesUserExist(userResourceDTO);

        UserResource userResource = new UserResource();
        userResource.setUserName(userResourceDTO.getUsername());
        userResource.setEmail(userResourceDTO.getEmail());
        userResource.setPassword(passwordEncoder.encode(userResourceDTO.getPassword()));
        userResource.setRole(UserRoleResource.USER);

        userResourceRepository.save(userResource);
    }

    private void doesUserExist(UserResourceDTO userResourceDTO) {
        if (userResourceRepository.existsByUserName(userResourceDTO.getEmail())) {
            throw new UserResourceException("Username already exists");
        }
    }
}

package dev.dtgaeh.workfromhere.users.repository;

import dev.dtgaeh.workfromhere.users.model.UserResource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserResourceRepository extends JpaRepository<UserResource, Integer> {
    Optional<UserResource> findByUserName(String username);
    Boolean existsByUserName(String username);
}

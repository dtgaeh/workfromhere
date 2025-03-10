package dev.dtgaeh.workfromhere.security.service;

import dev.dtgaeh.workfromhere.users.model.UserResource;
import dev.dtgaeh.workfromhere.users.model.UserRoleResource;
import dev.dtgaeh.workfromhere.users.repository.UserResourceRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserResourceDetailsService implements UserDetailsService {

    private final UserResourceRepository userResourceRepository;

    public UserResourceDetailsService(UserResourceRepository userResourceRepository) {
        this.userResourceRepository = userResourceRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserResource user = userResourceRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return new User(user.getUserName(), user.getPassword(), mapRoleToGrantedAuthority(user.getRole()));
    }

    private Collection<GrantedAuthority> mapRoleToGrantedAuthority(UserRoleResource role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
    }
}

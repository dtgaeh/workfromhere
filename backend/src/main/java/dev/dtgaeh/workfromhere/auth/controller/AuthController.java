package dev.dtgaeh.workfromhere.auth.controller;

import dev.dtgaeh.workfromhere.users.dto.UserResourceDTO;
import dev.dtgaeh.workfromhere.users.service.UserResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private static final String BASE_AUTH_URL = "/api/v1/auth";

    private final AuthenticationManager authenticationManager;
    private final UserResourceService userResourceService;

    public AuthController(AuthenticationManager authenticationManager, UserResourceService userResourceService) {
        this.authenticationManager = authenticationManager;
        this.userResourceService = userResourceService;
    }

    @PostMapping(value = BASE_AUTH_URL + "/register")
    public ResponseEntity<String> registerUser(@RequestBody UserResourceDTO userResourceDTO) {
        userResourceService.registerUser(userResourceDTO);

        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping(value = BASE_AUTH_URL + "/login")
    public ResponseEntity<String> loginUser(@RequestBody UserResourceDTO userResourceDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userResourceDTO.getUsername(), userResourceDTO.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return ResponseEntity.ok("User logged in successfully");
    }

}

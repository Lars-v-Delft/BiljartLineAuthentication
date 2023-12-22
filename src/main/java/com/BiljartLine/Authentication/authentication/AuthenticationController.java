package com.BiljartLine.Authentication.authentication;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody LoginDTO loginDTO) {
        String token = authenticationService.login(loginDTO);
        return new AuthResponseDTO(token);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/register")
    public AuthResponseDTO register(@RequestBody @Valid RegisterDTO registerDTO) {
        String token = authenticationService.register(registerDTO);
        return new AuthResponseDTO(token);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/userdetails")
    public UserDetailsDTO getUserDetails(@RequestBody String jwt){
        UserDetails userDetails = authenticationService.getUserDetails(jwt);
        return new UserDetailsDTO(
                userDetails.getUsername(),
                userDetails.getAuthorities().stream().map(Objects::toString).collect(Collectors.toSet()),
                userDetails.isAccountNonExpired(),
                userDetails.isAccountNonLocked(),
                userDetails.isCredentialsNonExpired(),
                userDetails.isEnabled()
        );
    }
}

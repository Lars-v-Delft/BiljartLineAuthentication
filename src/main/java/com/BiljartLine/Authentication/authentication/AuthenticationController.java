package com.BiljartLine.Authentication.authentication;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    // adapt to return JWT token?
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
}

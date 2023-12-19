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
    public String login(@RequestBody LoginDTO loginDTO) {
        return authenticationService.login(loginDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/register")
    public String register(@RequestBody @Valid RegisterDTO registerDTO) {
        return authenticationService.register(registerDTO);
    }
}

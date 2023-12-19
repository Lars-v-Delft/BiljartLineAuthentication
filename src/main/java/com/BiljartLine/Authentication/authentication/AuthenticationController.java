package com.BiljartLine.Authentication.authentication;

import com.BiljartLine.Authentication.config.JwtService;
import com.BiljartLine.Authentication.exceptions.InvalidArgumentException;
import com.BiljartLine.Authentication.user.BiljartLineUser;
import com.BiljartLine.Authentication.user.Role;
import com.BiljartLine.Authentication.user.UserRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
//https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/index.html#publish-authentication-manager-bean
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    // adapt to return JWT token?
    public void login(@RequestBody LoginDTO loginloginDTO) {
        // create unauthenticated request
        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(loginloginDTO.username(), loginloginDTO.password());
        // authenticate request
        Authentication authenticationResponse =
                authenticationManager.authenticate(authenticationRequest);
        // ...


//        return jwtService.generateToken(authenticationResponse.getPrincipal())
//
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterDTO registerDTO){
        if (userRepo.existsByUsername(registerDTO.getUsername()))
            throw new InvalidArgumentException("Username already exists");

        BiljartLineUser user = new BiljartLineUser();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setRole(Role.USER);

        userRepo.save(user);
    }

}

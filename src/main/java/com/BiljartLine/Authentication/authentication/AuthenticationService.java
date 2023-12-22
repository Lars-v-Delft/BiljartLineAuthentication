package com.BiljartLine.Authentication.authentication;

import com.BiljartLine.Authentication.config.JwtService;
import com.BiljartLine.Authentication.exceptions.InvalidArgumentException;
import com.BiljartLine.Authentication.user.BiljartLineUser;
import com.BiljartLine.Authentication.user.Role;
import com.BiljartLine.Authentication.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
//https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/index.html#publish-authentication-manager-bean
public class AuthenticationService {

    private final UserRepo userRepo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public String login(LoginDTO loginDTO) {
        // create unauthenticated request
        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(loginDTO.username(), loginDTO.password());

        // authenticate request
        Authentication authenticationResponse =
                authenticationManager.authenticate(authenticationRequest);

        return jwtService.generateToken((UserDetails) authenticationResponse.getPrincipal());
    }

    public String register(RegisterDTO registerDTO) {
        if (userRepo.existsByUsername(registerDTO.getUsername()))
            throw new InvalidArgumentException("Username already exists");

        BiljartLineUser user = new BiljartLineUser();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setRole(Role.USER);

        userRepo.save(user);

        return jwtService.generateToken(user);
    }

    public UserDetails getUserDetails(String jwt) {
        jwtService.validate(jwt);

        String username = jwtService.getSubject(jwt);
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
}

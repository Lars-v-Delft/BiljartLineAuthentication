package com.BiljartLine.Authentication.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(r -> r
//                        .requestMatchers("/authentication/**")
//                        .permitAll())
//                .sessionManagement(s -> s
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();

        // .csrf(csrf -> csrf.disable()
        // requestmatchers (path) . permitall()

//        return httpSecurity.build();
    }

    //https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/index.html#publish-authentication-manager-bean
    @Bean
    // authenticates userDetails using one or more AuthenticationProviders
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {

        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(authenticationProvider);
    }

    //https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/index.html#publish-authentication-manager-bean
    @Bean
    // encodes plain text password to hash
    public PasswordEncoder passwordEncoder() {
        // default implementation of Spring Security,
        // this uses the current password storage recommendations and is compatible with legacy formats,
        // results in {id}encodedPassword, as of 19/12/2023 like {bcrypt}$2a$10$dXJ3SW6G7...
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

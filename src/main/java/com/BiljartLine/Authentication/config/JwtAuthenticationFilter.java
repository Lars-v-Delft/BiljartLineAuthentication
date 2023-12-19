package com.BiljartLine.Authentication.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
//@RequiredArgsConstructor
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//    private final JwtService jwtService;
//    private final UserDetailsService userDetailsService;
//
//    @Override
//    protected void doFilterInternal(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain filterChain
//    ) throws ServletException, IOException {
//        final String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//        // check if header has jwt
//        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//        final String jwt = authorizationHeader.substring(7);
//        final String username = jwtService.getSubject(jwt);
//        // check if jwt is known
//        // todo: vraag stijn
//        // check if jwt is already in memory
//
//        // SecurityContextHolder is store for who is authenticated
//        // SecurityContext contains authentication of currently authenticated user
//        // Authentication contains data of currently authenticated user
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//            if (jwtService.isJWTValid(jwt, userDetails)) {
//                //https://docs.spring.io/spring-security/reference/servlet/authentication/architecture.html#servlet-authentication-securitycontextholder
//                SecurityContext context = SecurityContextHolder.createEmptyContext();
//                Authentication authentication =
//                        new UsernamePasswordAuthenticationToken(
//                                userDetails,
//                                userDetails.getPassword(),
//                                userDetails.getAuthorities());
//                context.setAuthentication(authentication);
//                SecurityContextHolder.setContext(context);
//
////                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
////                        userDetails,
////                        null,
////                        userDetails.getAuthorities()
////                );
////                authToken.setDetails(
////                        new WebAuthenticationDetailsSource()
////                                .buildDetails(request)
////                );
////                SecurityContextHolder.getContext().setAuthentication(authToken);
//            }
//        }
//        filterChain.doFilter(request, response);
//    }
//}

package com.BiljartLine.Authentication.authentication;

import java.util.Set;

public record UserDetailsDTO(
        String username,
        Set<String> roles,
        boolean isAccountNonExpired,
        boolean isAccountNonLocked,
        boolean isCredentialsNonExpired,
        boolean isEnabled) {
}

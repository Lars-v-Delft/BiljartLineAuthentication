package com.BiljartLine.Authentication.authentication;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
    @Size(min = 5, max = 20)
    private String username;
    // Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&/])[A-Za-z\\d@$!%*?&/]{8,}$")
    private String password;
}

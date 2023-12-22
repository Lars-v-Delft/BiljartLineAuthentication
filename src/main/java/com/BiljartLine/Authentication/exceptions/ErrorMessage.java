package com.BiljartLine.Authentication.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Getter
public class ErrorMessage {
    private final HttpStatus status;
    private final String message;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private final Instant timestampUTC;

    public ErrorMessage(HttpStatus status, String message){
        this.status = status;
        this.message = message;
        timestampUTC = Instant.now();
    }
}

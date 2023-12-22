package com.BiljartLine.Authentication.exceptions;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorMessage handleException(Exception e) {
        log.warn("An Exception occurred", e);
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.warn("An MethodArgumentNotValidException occurred", e);
        Map<String, String> errorMap = new HashMap<>();
        e.getBindingResult()
                .getFieldErrors()
                .forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidArgumentException.class)
    public ErrorMessage handleApiInvalidArgumentException(InvalidArgumentException e) {
        log.warn("An InvalidArgumentException occurred", e);
        return new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadCredentialsException.class)
    public ErrorMessage handleBadCredentialsException(BadCredentialsException e) {
        log.warn("An BadCredentialsException occurred", e);
        return new ErrorMessage(HttpStatus.BAD_REQUEST, "Credentials invalid");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UsernameNotFoundException.class)
    public ErrorMessage handleUsernameNotFoundException(UsernameNotFoundException e) {
        log.warn("An UsernameNotFoundException occurred", e);
        return new ErrorMessage(HttpStatus.BAD_REQUEST, "Username not found");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ExpiredJwtException.class)
    public ErrorMessage handleExpiredJwtException(ExpiredJwtException e) {
        log.warn("An ExpiredJwtException occurred", e);
        return new ErrorMessage(HttpStatus.BAD_REQUEST, "JWT expired");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UnsupportedJwtException.class)
    public ErrorMessage handleUnsupportedJwtException(UnsupportedJwtException e) {
        log.warn("An UnsupportedJwtException occurred", e);
        return new ErrorMessage(HttpStatus.BAD_REQUEST, "JWT not supported");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MalformedJwtException.class)
    public ErrorMessage handleMalformedJwtException(MalformedJwtException e) {
        log.warn("An MalformedJwtException occurred", e);
        return new ErrorMessage(HttpStatus.BAD_REQUEST, "JWT malformed");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SignatureException.class)
    public ErrorMessage handleSignatureException(SignatureException e) {
        log.warn("An SignatureException occurred", e);
        return new ErrorMessage(HttpStatus.BAD_REQUEST, "JWT signature invalid");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorMessage handleIllegalArgumentException(IllegalArgumentException e) {
        log.warn("An IllegalArgumentException occurred", e);
        return new ErrorMessage(HttpStatus.BAD_REQUEST, "Bad argument");
    }
}

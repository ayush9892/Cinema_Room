package com.it.cinemaroom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class WrongPasswordException extends RuntimeException {
    @Override
    public String getMessage() {
        return "The password is wrong!";
    }
}

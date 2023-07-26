package com.it.cinemaroom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongTokenException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Wrong token!";
    }
}

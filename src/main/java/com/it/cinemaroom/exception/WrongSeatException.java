package com.it.cinemaroom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongSeatException extends RuntimeException {
    public WrongSeatException() {
        super("The number of a row or a column is out of bounds!");
    }
}

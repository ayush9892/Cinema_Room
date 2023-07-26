package com.it.cinemaroom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SeatAlreadyBookedException extends RuntimeException {
    public SeatAlreadyBookedException() {
        super("The ticket has been already purchased!");
    }
}

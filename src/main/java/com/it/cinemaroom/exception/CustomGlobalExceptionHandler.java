package com.it.cinemaroom.exception;

import com.it.cinemaroom.model.CustomErrorResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler {

    @ExceptionHandler(SeatAlreadyBookedException.class)
    public ResponseEntity<CustomErrorResponseModel> customHandleSeatAlreadyBooked(SeatAlreadyBookedException ex) {
        return new ResponseEntity<>(
                new CustomErrorResponseModel(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<CustomErrorResponseModel> customHandleWrongPassword(WrongPasswordException ex) {
        return new ResponseEntity<>(
                new CustomErrorResponseModel(ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(WrongSeatException.class)
    public ResponseEntity<CustomErrorResponseModel> customHandleWrongSeat(WrongSeatException ex) {
        return new ResponseEntity<>(
                new CustomErrorResponseModel(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongTokenException.class)
    public ResponseEntity<CustomErrorResponseModel> customHandleWrongToken(WrongTokenException ex) {
        return new ResponseEntity<>(
                new CustomErrorResponseModel(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}

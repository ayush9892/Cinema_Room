package com.it.cinemaroom.exceptionhandler;

import com.it.cinemaroom.exception.SeatAlreadyBookedException;
import com.it.cinemaroom.model.ErrorResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SeatAlreadyBookedExceptionHandler {
    @ExceptionHandler(SeatAlreadyBookedException.class)
    public ResponseEntity<ErrorResponseModel> handleException(SeatAlreadyBookedException ex) {
        ErrorResponseModel errorResponseModel = new ErrorResponseModel(ex.getMessage());
        return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
    }
}

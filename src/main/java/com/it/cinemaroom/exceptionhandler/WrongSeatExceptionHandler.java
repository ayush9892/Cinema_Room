package com.it.cinemaroom.exceptionhandler;

import com.it.cinemaroom.exception.WrongSeatException;
import com.it.cinemaroom.model.ErrorResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WrongSeatExceptionHandler {
    @ExceptionHandler(WrongSeatException.class)
    public ResponseEntity<ErrorResponseModel> handleException(WrongSeatException ex) {
        ErrorResponseModel errorResponseModel = new ErrorResponseModel(ex.getMessage());
        return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
    }
}

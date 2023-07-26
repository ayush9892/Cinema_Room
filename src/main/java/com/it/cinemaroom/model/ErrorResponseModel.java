package com.it.cinemaroom.model;

public class ErrorResponseModel {
    private String error;

    public ErrorResponseModel(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

}

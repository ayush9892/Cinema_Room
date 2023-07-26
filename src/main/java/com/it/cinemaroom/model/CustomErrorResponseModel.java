package com.it.cinemaroom.model;

public class CustomErrorResponseModel {
    private String error;

    public CustomErrorResponseModel(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

}

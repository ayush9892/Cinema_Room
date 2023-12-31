package com.it.cinemaroom.model;


import java.util.ArrayList;


public class RoomModel {
    private int total_rows;
    private int total_columns;
    private ArrayList<TicketModel> available_seats;

    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }


    public ArrayList<TicketModel> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(ArrayList<TicketModel> available_seats) {
        this.available_seats = available_seats;
    }
}

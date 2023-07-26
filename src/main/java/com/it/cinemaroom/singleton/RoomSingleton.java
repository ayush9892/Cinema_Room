package com.it.cinemaroom.singleton;

import com.it.cinemaroom.model.TicketModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RoomSingleton {
    private int total_rows;
    private int total_columns;
    private ArrayList<TicketModel> seats;
    private final Map<String, TicketModel> bookedTickets;

    private static RoomSingleton roomSingleton;

    private RoomSingleton() {
        this.bookedTickets = new HashMap<>();
    }

    public static RoomSingleton getRoomInstance() {
        if (roomSingleton == null) {
            roomSingleton = new RoomSingleton();
            roomSingleton.setTotal_rows(9);
            roomSingleton.setTotal_columns(9);
            ArrayList<TicketModel> availableSeats = new ArrayList<>();
            for (int row = 1; row <= 9; row++) {
                for (int col = 1; col <= 9; col++) {
                    TicketModel ticketModel = new TicketModel();
                    ticketModel.setRow(row);
                    ticketModel.setColumn(col);
                    if(row <= 4)
                        ticketModel.setPrice(10);
                    else
                        ticketModel.setPrice(8);
                    availableSeats.add(ticketModel);
                }
            }
            roomSingleton.setSeats(availableSeats);
        }
        return roomSingleton;
    }

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

    public ArrayList<TicketModel> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<TicketModel> seats) {
        this.seats = seats;
    }

    public Map<String, TicketModel> getBookedTickets() {
        return bookedTickets;
    }

    public void addBookedTickets(String token, TicketModel ticketModel) {
        bookedTickets.put(token, ticketModel);
    }

}

package com.it.cinemaroom.service;

import com.it.cinemaroom.model.PurchaseTicketModel;
import com.it.cinemaroom.model.ReturnTicketModel;
import com.it.cinemaroom.model.RoomModel;
import com.it.cinemaroom.model.StatsModel;

public interface RoomService {
    RoomModel getAvailableSeats();
    PurchaseTicketModel bookSeat(int row, int col) throws RuntimeException;
    ReturnTicketModel returnTicket(String token) throws RuntimeException;
    StatsModel showingStats(String password) throws RuntimeException;
}

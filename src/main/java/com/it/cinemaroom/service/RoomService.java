package com.it.cinemaroom.service;

import com.it.cinemaroom.model.PurchaseTicketModel;
import com.it.cinemaroom.model.RoomModel;
import com.it.cinemaroom.model.StatsModel;
import com.it.cinemaroom.model.TicketModel;

import java.util.Map;

public interface RoomService {
    RoomModel getAvailableSeats();
    PurchaseTicketModel bookSeat(TicketModel selectedTicket) throws RuntimeException;
    Map<String, Object> returnTicket(String token) throws RuntimeException;
    StatsModel showingStats(String password) throws RuntimeException;
}

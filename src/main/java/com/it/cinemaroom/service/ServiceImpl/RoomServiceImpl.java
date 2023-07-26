package com.it.cinemaroom.service.ServiceImpl;

import com.it.cinemaroom.exception.SeatAlreadyBookedException;
import com.it.cinemaroom.exception.WrongPasswordException;
import com.it.cinemaroom.exception.WrongSeatException;
import com.it.cinemaroom.exception.WrongTokenException;
import com.it.cinemaroom.model.*;
import com.it.cinemaroom.service.RoomService;
import com.it.cinemaroom.singleton.RoomSingleton;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {
   private final RoomSingleton roomInstance = RoomSingleton.getRoomInstance();

   // Showing all seats.
    @Override
    public RoomModel getAvailableSeats() {
        RoomModel roomModel = new RoomModel();
        roomModel.setTotal_rows(roomInstance.getTotal_rows());
        roomModel.setTotal_columns(roomInstance.getTotal_columns());

        ArrayList<TicketModel> availableSeats = roomInstance.getSeats().stream()
                .filter(ticket -> !ticket.isBooked())
                .collect(Collectors.toCollection(ArrayList::new));

        roomModel.setAvailable_seats(availableSeats);

        return roomModel;
    }

    // Booking Ticket.
    @Override
    public PurchaseTicketModel bookSeat(TicketModel selectedTicket) throws RuntimeException {
        if(selectedTicket.getRow() > 9 || selectedTicket.getRow() < 1 ||
                selectedTicket.getColumn() > 9 || selectedTicket.getColumn() < 1)
            throw new WrongSeatException();

        ArrayList<TicketModel> availableSeats = roomInstance.getSeats();
        TicketModel seat = availableSeats.stream()
                .filter(ticket -> ticket.getRow() == selectedTicket.getRow() &&
                        ticket.getColumn() == selectedTicket.getColumn() &&
                        !ticket.isBooked())
                .findAny()
                .orElseThrow(SeatAlreadyBookedException::new);
        seat.setBooked(true);
        PurchaseTicketModel purchasedTicket = new PurchaseTicketModel(seat);
        roomInstance.addBookedTickets(purchasedTicket.getToken(), seat);
        return purchasedTicket;
    }

    // Returning Booked Ticket.
    @Override
    public Map<String, Object> returnTicket(String token) throws RuntimeException {
        TicketModel ticket = roomInstance.getBookedTickets().get(token);
        if(ticket == null) {
            throw new WrongTokenException();
        } else {
            ticket.setBooked(false);
            return Map.of("returned_ticket", ticket);
        }
    }

    // Calculate Stats for theater Manager
    @Override
    public StatsModel showingStats(String password) throws RuntimeException {
        if (!password.equals("super_secret")) {
            throw new WrongPasswordException();
        } else {
            int currentIncome = roomInstance.getSeats().stream()
                    .filter(TicketModel::isBooked)
                    .map(TicketModel::getPrice)
                    .reduce(0, Integer::sum);
            int purchasedTickets = roomInstance.getBookedTickets().size();

            StatsModel statsModel = new StatsModel();
            statsModel.setCurrent_income(currentIncome);
            statsModel.setNumber_of_purchased_tickets(purchasedTickets);
            statsModel.setNumber_of_available_seats(81 - purchasedTickets);
            return statsModel;
        }
    }
}

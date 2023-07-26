package com.it.cinemaroom.controller;

import com.it.cinemaroom.model.*;
import com.it.cinemaroom.service.RoomService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoomController {
    final private RoomService roomService;

    RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("seats")
    public ResponseEntity<RoomModel> getSeats() {
        return new ResponseEntity<>(roomService.getAvailableSeats(), HttpStatus.OK);
    }

    @PostMapping("purchase")
    public ResponseEntity<PurchaseTicketModel> bookSeat(@RequestBody TicketModel ticketModel) {
        return new ResponseEntity<>(roomService.bookSeat(ticketModel.getRow(), ticketModel.getColumn()), HttpStatus.OK);
    }

    @PostMapping("return")
    public ResponseEntity<ReturnTicketModel> returnTicket(@RequestBody PurchaseTicketModel ticket) {
        return new ResponseEntity<>(roomService.returnTicket(ticket.getToken()), HttpStatus.OK);
    }

    @PostMapping("stats")
    public ResponseEntity<StatsModel> getStats(@PathParam(value = "password")String password) {
        return new ResponseEntity<>(roomService.showingStats(password), HttpStatus.OK);
    }
}

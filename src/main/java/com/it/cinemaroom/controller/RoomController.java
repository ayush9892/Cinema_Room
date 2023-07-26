package com.it.cinemaroom.controller;

import com.it.cinemaroom.model.*;
import com.it.cinemaroom.service.RoomService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public ResponseEntity<PurchaseTicketModel> bookSeat(@RequestBody TicketModel selectedTicket) {
        return new ResponseEntity<>(roomService.bookSeat(selectedTicket), HttpStatus.OK);
    }

    @PostMapping("return")
    public Map<String, Object> returnTicket(@RequestBody PurchaseTicketModel ticket) {
        return roomService.returnTicket(ticket.getToken());
    }

    @PostMapping("stats")
    public ResponseEntity<StatsModel> getStats(@PathParam(value = "password")String password) {
        return new ResponseEntity<>(roomService.showingStats(password), HttpStatus.OK);
    }
}

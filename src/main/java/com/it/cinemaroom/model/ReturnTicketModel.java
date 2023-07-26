package com.it.cinemaroom.model;

public class ReturnTicketModel {
    private final TicketModel returned_ticket;

    public ReturnTicketModel(TicketModel ticketModel) {
        returned_ticket = ticketModel;
    }

    public TicketModel getReturned_ticket() {
        return returned_ticket;
    }
}

package com.it.cinemaroom.model;

import java.util.UUID;

public class PurchaseTicketModel {
    private String token;
    private TicketModel ticket;

    public PurchaseTicketModel(){}

    public PurchaseTicketModel(TicketModel ticketModel) {
        token = UUID.randomUUID().toString();
        this.ticket = ticketModel;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TicketModel getTicket() {
        return ticket;
    }
}

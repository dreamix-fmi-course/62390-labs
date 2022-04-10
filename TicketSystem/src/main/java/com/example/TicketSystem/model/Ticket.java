package com.example.TicketSystem.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Getter
public class Ticket {
    private UUID ticketId;
    private BigDecimal price;
    private int row;
    private int seat;
    private User user;
    private Event event;

    public  Ticket(BigDecimal price, int row, int seat, User user, Event event) {
        this.ticketId = UUID.randomUUID();
        this.price = price;
        this.row = row;
        this.seat = seat;
        this.user = user;
        this.event = event;
    }

    public int hashCode()
    {
        return Objects.hash(this.ticketId, this.price, this.row, this.seat, this.user, this.event);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o)
        {
            return false;
        }
        if(o == null || this.getClass() != o.getClass())
        {
            return false;
        }
        return Objects.equals(this.ticketId, ((Ticket) o).getTicketId());
    }
}

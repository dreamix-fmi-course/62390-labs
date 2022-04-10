package com.example.TicketSystem.service;

import com.example.TicketSystem.model.Event;
import com.example.TicketSystem.model.Ticket;
import com.example.TicketSystem.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface TicketServiceInterface {
    /**
     * Create and validate ticket.
     * Can NOT create ticket in the past.
     * Can NOT create ticket with negative price.
     * Can NOT duplicate row and seat same event.
     * @param u
     */
    void createTicket(Ticket u);

    void removeTicket(UUID id);

    Ticket findById(UUID id);

    void updateTicket(Ticket ticket);

    /**
     * Return all tickets bought by a user
     * @param id
     * @return
     */
    List<Ticket> findAllTicketsByUser(User id);

    /**
     * Return all sold tickets by event
     * @param event
     * @return
     */
    List<Ticket> findAllTicketByEvent(Event event);

    /**
     * Return all available events for between two dates
     * @param from
     * @param to
     * @return
     */
    List<Event> findAllEventsBetweenDates(LocalDate from, LocalDate to);
}

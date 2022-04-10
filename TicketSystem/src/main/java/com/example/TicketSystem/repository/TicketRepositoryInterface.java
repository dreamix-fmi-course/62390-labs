package com.example.TicketSystem.repository;

import com.example.TicketSystem.model.Ticket;

import java.util.List;
import java.util.UUID;

public interface TicketRepositoryInterface {
    /**
     * Create ticket
     */
    void createTicket(Ticket u);

    /**
     * Remove ticket
     */
    void removeTicket(UUID id);

    /**
     * Find ticket by Id
     */
    Ticket findById(UUID id);

    /**
     * Update ticket information
     */
    void updateTicketById(Ticket ticket);

    List<Ticket> getAllTickets();
}

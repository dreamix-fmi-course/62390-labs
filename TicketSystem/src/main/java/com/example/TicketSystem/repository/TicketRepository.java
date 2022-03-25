package com.example.TicketSystem.repository;

import com.example.TicketSystem.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class TicketRepository implements TicketRepositoryInterface{
    Map<UUID, Ticket> tickets = new ConcurrentHashMap<>();

    @Override
    public void createTicket(Ticket u) {
        this.tickets.put(u.getTicketId(), u);
    }

    @Override
    public void removeTicket(UUID id) {
        this.tickets.remove(id);
    }

    @Override
    public Ticket findById(UUID id) {
        return this.tickets.getOrDefault(id, null);
    }

    @Override
    public void updateTicketById(Ticket ticket) {
        this.tickets.replace(ticket.getTicketId(), ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return this.tickets.values().stream().collect(Collectors.toList());
    }
}

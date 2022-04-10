package com.example.TicketSystem.service;

import com.example.TicketSystem.config.AppConfig;
import com.example.TicketSystem.model.Event;
import com.example.TicketSystem.model.Ticket;
import com.example.TicketSystem.model.User;
import com.example.TicketSystem.repository.EventRepository;
import com.example.TicketSystem.repository.TicketRepository;
import com.example.TicketSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TicketService implements TicketServiceInterface{
    private TicketRepository ticketDb;
    private EventRepository eventDb;
    private AppConfig appConfig;

    @Autowired
    public TicketService(TicketRepository ticketDb, EventRepository eventDb, AppConfig appConfig) {
        this.ticketDb = ticketDb;
        this.eventDb = eventDb;
        this.appConfig = appConfig;
    }

    @Override
    public void createTicket(Ticket u) throws Exception {
        int maxRow = this.appConfig.getEvent().getMaximumRow();
        int maxSeat = this.appConfig.getEvent().getMaximumSeat();

        long count = this.ticketDb.getAllTickets().stream()
                .filter(t -> t.getEvent().equals(u.getEvent()) && t.getRow() == u.getRow() && t.getSeat() == u.getSeat())
                .count();
        if(count > 0 || u.getRow() > maxRow || u.getSeat() > maxSeat)
        {
            throw new Exception("Invalid ticket data");
        }

        this.ticketDb.createTicket(u);
    }

    @Override
    public void removeTicket(UUID id) {
        this.ticketDb.removeTicket(id);
    }

    @Override
    public Ticket findById(UUID id) {
        return this.ticketDb.findById(id);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        this.ticketDb.updateTicketById(ticket);
    }

    @Override
    public List<Ticket> findAllTicketsByUser(User id) {
        return this.ticketDb.getAllTickets().stream()
                .filter(u -> u.getUser().getId().equals(id.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> findAllTicketByEvent(Event event) {
        return this.ticketDb.getAllTickets().stream()
                .filter(e -> e.getEvent().getEventId().equals(event.getEventId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Event> findAllEventsBetweenDates(LocalDate from, LocalDate to) {
        return this.eventDb.getAllEvents().stream()
                .filter(e -> e.getDate().toLocalDate().isBefore(to) && e.getDate().toLocalDate().isAfter(from))
                .collect(Collectors.toList());
    }
}

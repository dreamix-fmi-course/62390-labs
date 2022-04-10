package com.example.TicketSystem.service;

import com.example.TicketSystem.model.Event;
import com.example.TicketSystem.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EventService implements EventServiceInterface{
    @Autowired
    private EventRepository eventDb;

    @Override
    public void createEvent(Event u) {
        this.eventDb.createEvent(u);
    }

    @Override
    public void removeEvent(UUID id) {
        this.eventDb.removeEvent(id);
    }

    @Override
    public Event findById(UUID id) {
        return this.eventDb.findById(id);
    }

    @Override
    public void updateEvent(Event event) {
        this.eventDb.updateEvent(event);
    }
}

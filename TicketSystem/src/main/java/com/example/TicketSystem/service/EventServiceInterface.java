package com.example.TicketSystem.service;

import com.example.TicketSystem.model.Event;

import java.util.UUID;

public interface EventServiceInterface {
    void createEvent(Event u);

    void removeEvent(UUID id);

    Event findById(UUID id);

    void updateEvent(Event event);
}

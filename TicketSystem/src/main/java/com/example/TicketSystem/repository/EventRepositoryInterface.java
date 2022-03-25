package com.example.TicketSystem.repository;

import com.example.TicketSystem.model.Event;

import java.util.List;
import java.util.UUID;

public interface EventRepositoryInterface {
    /***
     * Create event
     * @param event
     */
    void createEvent(Event event);

    /**
     * Remove event
     * @param id
     */
    void removeEvent(UUID id);

    /**
     * Find event by id
     * @param id of the event
     * @return
     */
    Event findById(UUID id);


    /**
     * Update event information
     * @param event
     */
    void updateEvent(Event event);

    List<Event> getAllEvents();
}

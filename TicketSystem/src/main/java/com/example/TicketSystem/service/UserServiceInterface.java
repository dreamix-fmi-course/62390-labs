package com.example.TicketSystem.service;

import com.example.TicketSystem.model.Event;
import com.example.TicketSystem.model.User;

import java.util.List;
import java.util.UUID;

public interface UserServiceInterface {
    void createUser(User u);

    void deleteUser(UUID id);

    User findById(UUID id);

    void updateUserInformation(User user);

    /**
     * Return all visited events
     */
    List<Event> getAllVisitedEvent();

    /**
     * Return all visited events for the past month
     */
    List<Event> getAllVisitedEventsInPastMonth();

    List<User> getAllUsers();
}

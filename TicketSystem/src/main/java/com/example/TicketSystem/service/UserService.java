package com.example.TicketSystem.service;

import com.example.TicketSystem.model.Event;
import com.example.TicketSystem.model.User;
import com.example.TicketSystem.repository.TicketRepository;
import com.example.TicketSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceInterface {
    private UserRepository userDb;
    private TicketRepository ticketDb;

    @Autowired
    public UserService(UserRepository userDb, TicketRepository ticketDb) {
        this.userDb = userDb;
        this.ticketDb = ticketDb;
    }

    @Override
    public void createUser(User u) {
        this.userDb.addUser(u);
    }

    @Override
    public void deleteUser(UUID id) {
        this.userDb.deleteUser(id);
    }

    @Override
    public User findById(UUID id) {
        return this.userDb.findById(id);
    }

    @Override
    public void updateUserInformation(User user) {
        this.userDb.updateUser(user);
    }

    @Override
    public List<Event> getAllVisitedEvent() {
        return this.ticketDb.getAllTickets().stream()
                .map(t -> t.getEvent())
                .distinct()
                .filter(e -> e.getDate().compareTo(LocalDateTime.now())<0)
                .collect(Collectors.toList());
    }

    @Override
    public List<Event> getAllVisitedEventsInPastMonth() {
        return this.ticketDb.getAllTickets().stream()
                .map(t -> t.getEvent())
                .distinct()
                .filter(e -> e.getDate().compareTo(LocalDateTime.now().minusMonths(1))>=0 && e.getDate().compareTo(LocalDateTime.now())<0)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllUsers() {
        return this.userDb.getAllUsers();
    }
}

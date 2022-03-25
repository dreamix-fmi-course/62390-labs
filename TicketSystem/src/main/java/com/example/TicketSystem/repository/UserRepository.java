package com.example.TicketSystem.repository;

import com.example.TicketSystem.model.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository implements UserRepositoryInterface{
    Map<UUID, User> users = new ConcurrentHashMap<>();

    @Override
    public void addUser(User u) {
        this.users.put(u.getId(), u);
    }

    @Override
    public void deleteUser(UUID id) {
        this.users.remove(id);
    }

    @Override
    public User findById(UUID id) {
        return this.users.getOrDefault(id, null);
    }

    @Override
    public void updateUser(User user) {
        this.users.replace(user.getId(), user);
    }
}

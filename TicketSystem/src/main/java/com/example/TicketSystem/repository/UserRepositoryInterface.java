package com.example.TicketSystem.repository;

import com.example.TicketSystem.model.User;

import java.util.UUID;

public interface UserRepositoryInterface {
    /**
     * Create new user
     */
    void addUser(User u);

    /**
     * Delete user
     */
    void deleteUser(UUID id);

    /**
     * Find user by id
     */
    User findById(UUID id);

    /**
     * Update user information
     */
    void updateUser(User user);
}

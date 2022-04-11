package com.example.TicketSystem.controller;

import com.example.TicketSystem.logger.LoggerInterface;
import com.example.TicketSystem.model.User;
import com.example.TicketSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Profile("local")
@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private LoggerInterface logger;

    @PostMapping(
            value = "create",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity create(@RequestBody User user)
    {
        this.userService.createUser(user);
        logger.info("Created user " + user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Returned Code 201 (Created)");
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.findById(id));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity remove(@PathVariable UUID id) {
        this.userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted user successfully");
    }

    @GetMapping("all")
    public ResponseEntity<List<User>> all() {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getAllUsers());
    }
}

package com.example.TicketSystem.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dummy")
public class DummyController {

    @GetMapping("/hello-world")
    public String getStringValue()
    {
        return "SomeValue";
    }

    @PostMapping("/receiver")
    public String receiver(@RequestBody String arg)
    {
        return "Requested body " + arg;
    }
}

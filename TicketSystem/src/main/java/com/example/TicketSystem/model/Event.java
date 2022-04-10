package com.example.TicketSystem.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class Event {
    private UUID eventId;
    private String name;
    private LocalDateTime date;
    private String description;

    public Event(String name, LocalDateTime date, String description) {
        this.eventId = UUID.randomUUID();
        this.name = name;
        this.date = date;
        this.description = description;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.eventId, this.name, this.date, this.description);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o)
        {
            return false;
        }
        if(o == null || this.getClass() != o.getClass())
        {
            return false;
        }
        return Objects.equals(this.eventId, ((Event) o).getEventId());
    }
}

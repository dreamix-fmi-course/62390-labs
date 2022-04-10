package com.example.TicketSystem.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class User {
    private UUID id;
    private String userName;
    private String email;

    public User(String userName, String email) {
        this.id = UUID.randomUUID();
        this.userName = userName;
        this.email = email;
    }

    public int hashCode()
    {
        return Objects.hash(this.id, this.userName, this.email);
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
        return Objects.equals(this.id, ((User) o).getId());
    }
}

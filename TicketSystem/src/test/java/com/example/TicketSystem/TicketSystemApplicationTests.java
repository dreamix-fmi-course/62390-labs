package com.example.TicketSystem;

import com.example.TicketSystem.model.Event;
import com.example.TicketSystem.model.Ticket;
import com.example.TicketSystem.model.User;
import com.example.TicketSystem.service.EventServiceInterface;
import com.example.TicketSystem.service.TicketServiceInterface;
import com.example.TicketSystem.service.UserServiceInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
class TicketSystemApplicationTests {

	@Test
	void contextLoads() {
	}
}

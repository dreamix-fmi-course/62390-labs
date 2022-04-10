package com.example.TicketSystem.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@ConfigurationProperties(prefix = "config")
@Configuration
@Data
public class AppConfig {
    private LoggerConfig logger = new LoggerConfig();
    private  EventConfig event = new EventConfig();

    @ConfigurationProperties(prefix = "logger")
    @Data
    public class LoggerConfig {
        private String level;
    }

    @ConfigurationProperties(prefix = "event")
    @Data
    public class EventConfig
    {
        private int maximumRow;
        private int maximumSeat;
        private List<String> names;
        private List<String> descriptions;
    }
}

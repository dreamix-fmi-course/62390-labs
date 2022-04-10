package com.example.TicketSystem.logger;

public interface LoggerInterface {
    void info(Object toLog);

    void debug(Object toLog);

    void trace(Object toLog);

    void error(Object toLog);
}

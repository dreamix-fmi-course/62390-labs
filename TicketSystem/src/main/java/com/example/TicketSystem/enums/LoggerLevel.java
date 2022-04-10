package com.example.TicketSystem.enums;

public enum LoggerLevel {
    INFO(1, "INFO"),
    DEBUG(2, "DEBUG"),
    TRACE(3, "TRACE"),
    ERROR(0, "ERROR");

    private Integer code;
    private String label;

    LoggerLevel(Integer code, String label)
    {
        this.code = code;
        this.label = label;
    }

    public Integer getCode()
    {
        return this.code;
    }

    public String getLabel()
    {
        return this.label;
    }
}

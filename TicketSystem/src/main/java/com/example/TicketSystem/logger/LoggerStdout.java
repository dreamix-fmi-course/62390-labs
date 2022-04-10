package com.example.TicketSystem.logger;

import com.example.TicketSystem.config.AppConfig;
import com.example.TicketSystem.enums.LoggerLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local", "naroden"})
@Component
public class LoggerStdout implements LoggerInterface{
    private LoggerLevel loggerLevel;

    @Autowired
    public LoggerStdout(AppConfig appConfig)
    {
        this.loggerLevel = LoggerLevel.valueOf(appConfig.getLogger().getLevel());
    }

    @Override
    public void info(Object toLog) {
        if(loggerLevel.getCode().compareTo(LoggerLevel.INFO.getCode()) > 0)
        {
            System.out.println(toLog);
        }
    }

    @Override
    public void debug(Object toLog) {
        if(loggerLevel.getCode().compareTo(LoggerLevel.DEBUG.getCode()) >= 0)
        {
            System.out.println(toLog);
        }
    }

    @Override
    public void trace(Object toLog) {
        if(loggerLevel.getCode().compareTo(LoggerLevel.TRACE.getCode()) >= 0)
        {
            System.out.println(toLog);
        }
    }

    @Override
    public void error(Object toLog) {
        System.out.println(toLog);
    }
}

package com.example.TicketSystem.logger;

import com.example.TicketSystem.config.AppConfig;
import com.example.TicketSystem.enums.LoggerLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Profile("dev")
@Component
public class LoggerFile  implements  LoggerInterface{
    
    private LoggerLevel loggerLevel;

    @Autowired
    public LoggerFile(AppConfig appConfig)
    {
        this.loggerLevel = LoggerLevel.valueOf(appConfig.getLogger().getLevel());
    }

    @Override
    public void info(Object toLog) {
        if(loggerLevel.getCode().compareTo(LoggerLevel.INFO.getCode()) > 0)
        {
            LoggerLevel currentLogger = LoggerLevel.INFO;
            this.logInformation(toLog, currentLogger);
        }
    }

    @Override
    public void debug(Object toLog) {
        if(loggerLevel.getCode().compareTo(LoggerLevel.DEBUG.getCode()) >= 0)
        {
            LoggerLevel currentLogger = LoggerLevel.DEBUG;
            this.logInformation(toLog, currentLogger);
        }
    }

    @Override
    public void trace(Object toLog) {
        if(loggerLevel.getCode().compareTo(LoggerLevel.TRACE.getCode()) >= 0)
        {
            LoggerLevel currentLogger = LoggerLevel.TRACE;
            this.logInformation(toLog, currentLogger);
        }
    }

    @Override
    public void error(Object toLog) {
        LoggerLevel currentLogger = LoggerLevel.ERROR;
        this.logInformation(toLog, currentLogger);
    }

    private void logInformation(Object toLog, LoggerLevel currentLoggerLevel) {
        File log = new File("log.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(log, true))) {
            out.println(new Date() + " [" + currentLoggerLevel.getLabel() + "] - " + toLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

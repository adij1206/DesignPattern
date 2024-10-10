package com.aditya.DesignPattern.lld.loggingFramework;

import java.util.HashMap;
import java.util.Map;

public class Logger {

    private Map<String, LogContent> logContentMap;
    private LogLevel logLevel;
    private LogAppender logAppender;

    public Logger() {
        logContentMap = new HashMap<>();
        logLevel = LogLevel.DEBUG;
        logAppender = new ConsoleLongAppender();
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public void setLogAppender(LogAppender logAppender) {
        this.logAppender = logAppender;
    }

    public void info(String message) {
        LogContent logContent = new LogContent(message, LogLevel.INFO.getPriority());
        logContentMap.put(logContent.getId(), logContent);
    }


    public void debug(String message) {
        LogContent logContent = new LogContent(message, LogLevel.DEBUG.getPriority());
        logContentMap.put(logContent.getId(), logContent);
    }


    public void warn(String message) {
        LogContent logContent = new LogContent(message, LogLevel.WARN.getPriority());
        logContentMap.put(logContent.getId(), logContent);
    }


    public void error(String message) {
        LogContent logContent = new LogContent(message, LogLevel.ERROR.getPriority());
        logContentMap.put(logContent.getId(), logContent);
    }

    public void getLogMessages(Long timeStamp) {
        for (LogContent logContent : logContentMap.values()) {
            if (logContent.getCreatedTimestamp() > timeStamp && logContent.getLogLevel() >= logLevel.getPriority()) {
                logAppender.append(logContent.toString());
            }
        }
    }
}

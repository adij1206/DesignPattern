package com.aditya.DesignPattern.lld.loggingFramework;

public class Demo {

    public static void main(String[] args) {
        Logger logger = new Logger();

        logger.info("Hello World");
        logger.debug("Debug Message");
        logger.warn("Warn Message");
        logger.error("Error Message");

        logger.getLogMessages(System.currentTimeMillis()-10000);

        logger.setLogLevel(LogLevel.INFO);

        logger.getLogMessages(System.currentTimeMillis()-10000);
    }
}

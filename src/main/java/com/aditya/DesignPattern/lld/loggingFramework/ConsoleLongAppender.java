package com.aditya.DesignPattern.lld.loggingFramework;

public class ConsoleLongAppender implements LogAppender{


    @Override
    public void append(String message) {
        System.out.println(message);
    }
}

package com.sai.sri.siddhi.j2ee.design.behavioral.chainOfResponsibility;

public class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(int level) {
        this.logLevel = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Console Logger - " + message);
    }
}

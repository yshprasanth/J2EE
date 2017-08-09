package com.sai.sri.siddhi.j2ee.design.behavioral.chainOfResponsibility;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.logLevel = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Logger - " + message);
    }
}

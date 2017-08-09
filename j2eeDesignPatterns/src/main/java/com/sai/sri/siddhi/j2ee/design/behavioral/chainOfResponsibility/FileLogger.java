package com.sai.sri.siddhi.j2ee.design.behavioral.chainOfResponsibility;

public class FileLogger extends AbstractLogger{

    public FileLogger(int level) {
        this.logLevel = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("FileLogger - " + message);
    }
}

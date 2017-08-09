package com.sai.sri.siddhi.j2ee.design.behavioral.chainOfResponsibility;

public abstract class AbstractLogger {

    public final static int INFO=1;
    public final static int DEBUG=2;
    public final static int ERROR=3;

    protected int logLevel;

    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if(this.logLevel<=level){
            write(message);
        }

        if(nextLogger!=null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}

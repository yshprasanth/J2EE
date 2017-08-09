package com.sai.sri.siddhi.j2ee.design.behavioral.chainOfResponsibility;

public class MainApp {

    private static AbstractLogger getChainOfLogger() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLogger();

        loggerChain.logMessage(AbstractLogger.DEBUG, "Debug Hello world!!");
        loggerChain.logMessage(AbstractLogger.INFO, "Info Hello world!!");
        loggerChain.logMessage(AbstractLogger.ERROR, "Error Hello world!!");

    }
}

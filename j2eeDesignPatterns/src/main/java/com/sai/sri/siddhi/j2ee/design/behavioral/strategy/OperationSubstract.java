package com.sai.sri.siddhi.j2ee.design.behavioral.strategy;

public class OperationSubstract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
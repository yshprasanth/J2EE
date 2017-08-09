package com.sai.sri.siddhi.j2ee.design.behavioral.command;

public class BuyOrder implements Order {
    private  Stock abcStock;

    public BuyOrder(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}

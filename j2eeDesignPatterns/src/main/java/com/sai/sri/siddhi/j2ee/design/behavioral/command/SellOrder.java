package com.sai.sri.siddhi.j2ee.design.behavioral.command;

public class SellOrder implements Order {
    private Stock sellStock;
    public SellOrder(Stock stock) {
        this.sellStock = stock;
    }

    @Override
    public void execute() {
        sellStock.sell();
    }
}

package com.sai.sri.siddhi.j2ee.design.behavioral.command;

public class MainApp {

    public static void main(String[] args) {
        Stock stock = new Stock();
        BuyOrder buyOrder = new BuyOrder(stock);
        SellOrder sellOrder = new SellOrder(stock);

        Broker broker = new Broker();
        broker.takeOrder(buyOrder);
        broker.takeOrder(sellOrder);
        broker.placeOrders();


    }
}

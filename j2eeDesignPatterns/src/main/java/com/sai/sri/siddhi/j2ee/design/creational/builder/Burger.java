package com.sai.sri.siddhi.j2ee.design.creational.builder;

public abstract class Burger implements Item{
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}

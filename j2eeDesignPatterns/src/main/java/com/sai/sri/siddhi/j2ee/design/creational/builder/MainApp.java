package com.sai.sri.siddhi.j2ee.design.creational.builder;

public class MainApp {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal:");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        Meal chickenMeal = mealBuilder.prepareChickenMeal();
        System.out.println("Chicken Meal:");
        chickenMeal.showItems();
        System.out.println("Total Cost: " + chickenMeal.getCost());

    }
}

package com.example.cs246_app;
import com.google.gson.Gson;

public class MenuItem {
    String foodName;
    double price;

    public MenuItem(String foodName, double price) {
        this.foodName = foodName;
        this.price = price;
    }
}

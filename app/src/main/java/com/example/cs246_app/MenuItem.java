package com.example.cs246_app;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class MenuItem {
    String name;
    double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "name: " + name + "\nprice: " + price;
    }
}

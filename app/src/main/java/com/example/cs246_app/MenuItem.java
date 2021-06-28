package com.example.cs246_app;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class MenuItem {
    String foodName;
    double price;
    List<Map> foodList;

//    public MenuItem(String foodName, double price) {
//        this.foodName = foodName;
//        this.price = price;
//    }

    public MenuItem(List<Map> foodList) {
        this.foodList = foodList;
    }
}

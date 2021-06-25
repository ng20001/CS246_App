package com.example.cs246_app;
import com.google.gson.Gson;

public class Menu {
    String menuJson = new MenuList().Json;

    public void display() {
        //display menu items on the menu screen
        Gson gson = new Gson();
        MenuItem menuItem = gson.fromJson(menuJson, MenuItem.class);
    }

}

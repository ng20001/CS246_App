package com.example.cs246_app;
import com.google.gson.Gson;
import java.util.ArrayList;

public class Menu {
    ArrayList<MenuItem> MenuList;
    String menuJson = new MenuString().Json;

    Menu() {

    }

    public void display() {
        //display menu items on the menu screen
        Gson gson = new Gson();
        MenuItem[] menuItem = gson.fromJson(menuJson, MenuItem[].class);
        System.out.print(menuItem);
    }

}

package com.example.cs246_app;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class showOrders {
    OrderAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);



        //setContentView(R.layout.activity_edit_order);
        //displayItem();
        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Burger");
        animalNames.add("Sandwich");
        animalNames.add("Cake");
        animalNames.add("Tea");
        animalNames.add("Soda");

        //set the adapter

        //RecyclerView view = findViewById(R.id.recycler_orders);
        adapter = new OrderAdapter(this, animalNames);
        //view.setLayoutManager(new LinearLayoutManager(this));
        //view.setAdapter(adapter);
    }
}

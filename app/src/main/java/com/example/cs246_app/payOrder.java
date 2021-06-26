package com.example.cs246_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class payOrder extends AppCompatActivity {
    PayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_order);
        //displayItem();

        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Burger");
        animalNames.add("Sandwich");
        animalNames.add("Cake");
        animalNames.add("Tea");
        animalNames.add("Soda");

        //set the adapter
        RecyclerView view = findViewById(R.id.recycler_pay_orders);
        adapter = new PayAdapter(this, animalNames);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
    }

    /*public void displayItem(){
        String foodItem = "Burger";
        EditText text = findViewById(R.id.foodItemDisplay2);
        //set text to it
        text.setText(foodItem);
    }*/
}
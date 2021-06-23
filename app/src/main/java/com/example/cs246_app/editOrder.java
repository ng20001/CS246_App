package com.example.cs246_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class editOrder extends AppCompatActivity {
    OrderAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_order);
        //displayItem();
        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        //set the adapter
        RecyclerView view = findViewById(R.id.recycler_orders);
        adapter = new OrderAdapter(this, animalNames);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
    }





    public void displayItem(){
        String foodItem = "Burger";
        EditText text = findViewById(R.id.foodItemDisplay);
        //set text to it
        text.setText(foodItem);
    }
}
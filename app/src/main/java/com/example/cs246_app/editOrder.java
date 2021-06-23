package com.example.cs246_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class editOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_order);
        displayItem();
    }

    int item = 0;

    public void addItem(View view){
        item++;
        displayQuantity();
    }

    public void decreaseItem(View view){
        item--;
        displayQuantity();
    }

    public void displayQuantity(){
        //find view by id
        EditText text = findViewById(R.id.quantityBtn);
        //set text to it
        text.setText(String.valueOf(item));

    }

    public void displayItem(){
        String foodItem = "Burger";
        EditText text = findViewById(R.id.foodItemDisplay);
        //set text to it
        text.setText(foodItem);
    }
}
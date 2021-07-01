package com.example.cs246_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class showOrders extends AppCompatActivity {
    ShowAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit_order);
        //displayItem();
        // data to populate the RecyclerView with

        //set the adapter
        RecyclerView view = findViewById(R.id.recycler_show_orders);
        adapter = new ShowAdapter(this, MainActivity.INSTANCE.orders);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
    }
}

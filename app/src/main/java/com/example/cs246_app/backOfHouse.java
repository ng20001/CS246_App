package com.example.cs246_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Map;

public class backOfHouse extends AppCompatActivity {
    DisplayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_of_house);
        
        Bundle bundle = getIntent().getExtras();

        //change line to getExtra and change list to Map
        Map<MenuItem, Integer> myMap = (Map<MenuItem, Integer>) bundle.getParcelableArrayList("MENU");

        //transform map into list
        ArrayList<Map.Entry<MenuItem, Integer>> key = new ArrayList<Map.Entry<MenuItem, Integer>>(myMap. keySet());
        ArrayList<Integer> qty = new ArrayList<Integer>(myMap.values());

        //set the adapter
        //and give the list to the adapter
        RecyclerView view = findViewById(R.id.recycler_display_orders);
        adapter = new DisplayAdapter(this, key);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
    }

    public void onClickDone(View view){
        finish();
    }
}
package com.example.cs246_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class backOfHouse extends AppCompatActivity {
    DisplayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_of_house);

        Intent intent = getIntent();
        /*Bundle bundle = getIntent().getExtras();*/

        //change line to getExtra and change list to Map
        Map<String, String> myMap = (Map<String, String>) intent.getExtras().getParcelableArrayList("MENU");

        //transform map into list
        ArrayList<String> key = new ArrayList<>(myMap. keySet());
        ArrayList<Integer> qty = new ArrayList<>(myMap. values());

        //set the adapter
        //and give the list to the adapter
        /*RecyclerView view = findViewById(R.id.recycler_display_orders);
        adapter = new DisplayAdapter(this, keyList);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);*/
    }

    public void onClickDone(View view){
        finish();
    }
}
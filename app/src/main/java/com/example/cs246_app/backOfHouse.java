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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class backOfHouse extends AppCompatActivity {
    DisplayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_of_house);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        //change line to getExtra and change list to Map
//        Map<MenuItem, Integer> myMap = (Map<MenuItem, Integer>) bundle.getParcelableArrayList("MENU");
        HashMap<String, Integer> myMap = (HashMap<String, Integer>) bundle.getSerializable("MENU");

        System.out.println("'myMap'");
        System.out.println(myMap);

        //transform map into list
//        HashMap<String, String> key = new HashMap<String, String>(myMap);
//        System.out.println("'key'");
//        System.out.println(key);
//        ArrayList<String> qty = new ArrayList<>(myMap.values());
//        System.out.println("'qty'");
//        System.out.println(qty);

//        List<Map.Entry<String, String>> orderDetail = new ArrayList<>(myMap.entrySet());
        HashMap<String, Integer> orderDetail = new HashMap<>(myMap);
        System.out.println("'orderDetail'");
        System.out.println(orderDetail);

        RecyclerView view = findViewById(R.id.recycler_display_orders);
        adapter = new DisplayAdapter(this, orderDetail);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
    }

    public void onClickDone(View view){
        finish();
    }
}
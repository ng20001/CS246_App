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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class backOfHouse extends AppCompatActivity {
    DisplayAdapter adapter;
    //two lists that will be used
    private ArrayList<String> foodItems = new ArrayList<>();
    private ArrayList<Integer> foodQtys = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_of_house);
        System.out.println("Entered BOH");

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        //change line to getExtra and change list to Map
//        Map<MenuItem, Integer> myMap = (Map<MenuItem, Integer>) bundle.getParcelableArrayList("MENU");
        HashMap<String, Integer> myMap = (HashMap<String, Integer>) bundle.getSerializable("MENU");

//        List<Map.Entry<String, String>> orderDetail = new ArrayList<>(myMap.entrySet());
        HashMap<String, Integer> orderDetail = new HashMap<>(myMap);
        System.out.println("'orderDetail - to DisplayAdapter parameter'");
        System.out.println(orderDetail);

        Set entrySet = orderDetail.entrySet();
        Iterator it = entrySet.iterator();

        // Add keys and values from orderDetail(HashMap) into 2 arraylists using iterator
        while(it.hasNext()){
            Map.Entry me = (Map.Entry)it.next();
            foodItems.add(String.valueOf(me.getKey()));
            foodQtys.add((Integer) me.getValue());
        }

        System.out.println("foodItems: " + foodItems);
        System.out.println("foodQtys: " + foodQtys);

        RecyclerView view = findViewById(R.id.recycler_display_orders);
//        adapter = new DisplayAdapter(this, orderDetail);
        // Instead of a hashmap, pass 2 arraylist into DisplayAdapter
        adapter = new DisplayAdapter(this, foodItems, foodQtys);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
    }

    public void onClickDone(View view){
        //remove(key);
        Bundle args = getIntent().getExtras();
        String orderID = args.getString("ORDER_ID");
        MainActivity.orders.remove(orderID);
        finish();
    }
    public void onClickBack(View view){
        finish();
    }
}
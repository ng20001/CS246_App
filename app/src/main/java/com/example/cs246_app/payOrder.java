package com.example.cs246_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class payOrder extends AppCompatActivity {
    PayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_order);

        Intent intent = getIntent();
        Bundle args = intent.getExtras();
//        Log.d("debug", intent.getExtras().get());

        // Get the orderItems from editOrder.onClickPay()
//        Map<MenuItem, Integer> menu = (Map<MenuItem, Integer>) args.getSerializable("MENU");
        Map<MenuItem, Integer> menu = (Map<MenuItem, Integer>) args.getSerializable("MENU");
        double total = (double) args.getSerializable("Total");


        List<Map.Entry<MenuItem, Integer>> customOrder = new ArrayList<>(menu.entrySet());


        //update the Pay adapter to receive list
        //update the adapter so it populates the rows using the info from inside the list
        RecyclerView view = findViewById(R.id.recycler_pay_orders);
        TextView totalAmount = findViewById(R.id.total);

        adapter = new PayAdapter(this, customOrder);
        view.setLayoutManager(new LinearLayoutManager(this));

        // Q: Why is the listing order random?
        System.out.println("---------------------");
        for (int i = 0; i < customOrder.size(); i++) {
            System.out.println(adapter.getItem(i));
        }
        System.out.println("---------------------");

        totalAmount.setText("$" + total);
        view.setAdapter(adapter);

    }

    public void onClickSubmit(View view){
//        Button: "SUBMIT ORDER" to Layout: activity_main
//        1. Return to the main view
//        2. Send the order list to BOH

//        int Min = 1;
//        int Max = 100;
//        int val = Min + (int)(Math.random()*((Max - Min)+1));
//        String random = String.valueOf(val);
//        RecyclerView recyclerView = findViewById(R.id.recycler_show_orders);
//        Map<Map.Entry<MenuItem, Integer>, Integer> orderItems = new HashMap<>();
//        for(int i = 0; i<recyclerView.getChildCount(); i++){
//            PayAdapter.ViewHolder vh = (PayAdapter.ViewHolder) recyclerView.findViewHolderForAdapterPosition(i);
//            orderItems.put(adapter.getItem(i), vh.item);
//        }
//
//        MainActivity.INSTANCE.orders.put(random, orderItems);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
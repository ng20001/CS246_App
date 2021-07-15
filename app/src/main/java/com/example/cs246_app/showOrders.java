package com.example.cs246_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class showOrders extends AppCompatActivity {
    ShowAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_orders);
        System.out.println("Entered show order lists (order numbers)");

        Bundle bundle = getIntent().getExtras();
        //ArrayList<MenuItem> arraylist = bundle.getParcelableArrayList("MENU");

        //set the adapter
        RecyclerView view = findViewById(R.id.recycler_show_orders);

        adapter = new ShowAdapter(this, new ArrayList<>(MainActivity.INSTANCE.orders.keySet()));
        adapter.setClickListener(new ShowAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String item = adapter.getItem(position);

                // list init
//                HashMap<MenuItem, Integer> list = new HashMap<>();
                HashMap<String, Integer> list = new HashMap<>();

                //MainActivity.orders.get(item);
                for(Map.Entry<Map.Entry<MenuItem, Integer>, Integer> element : MainActivity.orders.get(item).entrySet()){

                    //get the menu item and the count
                    // Changed element.getValue() => element.getKey().getValue()
                    // "element" key: <MenuItem, Integer> (MenuItem, qty)
                    // MenuItem: foodItem, cost
                    // "element" value: Integer (? value)

//                    list.put(element.getKey().getKey(), element.getKey().getValue());
                    list.put(element.getKey().getKey().foodItem, element.getKey().getValue());
                }

                // Go to BOH(individual order details) when an order item # is clicked
                Intent intent = new Intent(showOrders.this, backOfHouse.class);
                // Send the individual order details along
                intent.putExtra("MENU", list);

                System.out.println("'list'");
                System.out.println(list);

                System.out.println("Entering BOH");
                startActivity(intent);
            }
        });
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        RecyclerView view = findViewById(R.id.recycler_show_orders);
        adapter = new ShowAdapter(this, new ArrayList<>(MainActivity.INSTANCE.orders.keySet()));
        view.setAdapter(adapter);
    }
}

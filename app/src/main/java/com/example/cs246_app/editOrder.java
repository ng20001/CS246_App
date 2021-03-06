package com.example.cs246_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class editOrder extends AppCompatActivity {
    OrderAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_order);

        // Get Json File from Menu class
        String jsonFileString = Menu.getJsonFromAssets(getApplicationContext(), "menu.json");
        // Display Json string on console
        assert jsonFileString != null;
//        Log.i("data", jsonFileString);

        Gson gson = new Gson();
        Type listMenuType = new TypeToken<List<MenuItem>>() { }.getType();

        //Assign list from json file
        List<MenuItem> menu = gson.fromJson(jsonFileString, listMenuType);

        //Debug
        for (int i = 0; i < menu.size(); i++) {
            Log.i("data", "> Item " + i + "\n" + menu.get(i));
        }

        //Set the adapter
        //OrderAdapter
        RecyclerView view = findViewById(R.id.recycler_orders);
        adapter = new OrderAdapter(this, menu);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
    }

    public void onClickPay(View view){
        //Button: "PROCEED TO PAY" to Layout: activity_pay_order
        //1. Go to pay view
        //2. Send the order list to pay view

        //Get recycler view: recycler_orders
        RecyclerView recyclerView = findViewById(R.id.recycler_orders);
        //orderItems: a list of HashMaps<MenuItem, Integer>
        HashMap<MenuItem, Integer> orderItems = new HashMap<>();

        double total = 0;
        double totalWT = 0;
        boolean validOrder = false;
        // Creating the recycler view for the pay list: vh
        for(int i = 0; i<recyclerView.getChildCount(); i++){
            // ??
            OrderAdapter.ViewHolder vh = (OrderAdapter.ViewHolder) recyclerView.findViewHolderForAdapterPosition(i);
            // adapter.getItem(i): MenuItem (foodItem, cost)
            // vh.item: Int (qty of foodItem)
            Intent intent = new Intent(this, payOrder.class);

            TextView nameView = findViewById(R.id.clientName);
            String name = nameView.getText().toString();
            intent.putExtra("NAME", name);
            if (vh.item != 0) { // Only include the food item that has qty >= 1
                orderItems.put(adapter.getItem(i), vh.item);
                total += adapter.getItem(i).cost * vh.item;
                validOrder = true;
            }
            totalWT = total + total*0.15;
        }

        if (validOrder){
            Intent intent = new Intent(this, payOrder.class);

            TextView nameView = findViewById(R.id.clientName);
            String name = nameView.getText().toString();
            intent.putExtra("NAME", name);

            intent.putExtra("MENU", orderItems);
            intent.putExtra("Total", total);
            intent.putExtra("TotalWT", totalWT);
            startActivity(intent);
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Order at least 1 item!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
    public void onclickBack(View view){
        finish();
    }
}
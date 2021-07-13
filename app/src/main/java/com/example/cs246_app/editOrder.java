package com.example.cs246_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

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


        String jsonFileString = Menu.getJsonFromAssets(getApplicationContext(), "menu.json");
        // Display Json string on console
        assert jsonFileString != null;
        Log.i("data", jsonFileString);

        Gson gson = new Gson();
        Type listMenuType = new TypeToken<List<MenuItem>>() { }.getType();

        List<MenuItem> menu = gson.fromJson(jsonFileString, listMenuType);
        for (int i = 0; i < menu.size(); i++) {
            Log.i("data", "> Item " + i + "\n" + menu.get(i));
        }
        //set the adapter
        RecyclerView view = findViewById(R.id.recycler_orders);
        adapter = new OrderAdapter(this, menu);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
    }

    public void onClickPay(View view){
        RecyclerView recyclerView = findViewById(R.id.recycler_orders);
        HashMap<MenuItem, Integer> orderItems = new HashMap<>();
        for(int i = 0; i<recyclerView.getChildCount(); i++){
            OrderAdapter.ViewHolder vh = (OrderAdapter.ViewHolder) recyclerView.findViewHolderForAdapterPosition(i);
            orderItems.put(adapter.getItem(i), vh.item);
        }
        Intent intent = new Intent(this, payOrder.class);
        intent.putExtra("MENU", orderItems);
        startActivity(intent);
    }
    /*public void onClickPayOrder(View view){
        Intent intent = new Intent(this, payOrder.class);
        startActivity(intent);
    }*/
//adding comments
}
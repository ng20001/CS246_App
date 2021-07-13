package com.example.cs246_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static MainActivity INSTANCE = null;
    Map<String, Map<Map.Entry<MenuItem, Integer>, Integer>> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (INSTANCE == null) {
            INSTANCE = this;
            this.orders = new HashMap<String, Map<Map.Entry<MenuItem, Integer>, Integer>>();
        } else {
            //throw error
            Log.wtf("MainActivity", "An error occurred");
        }
    }

    public void onClickAddOrder(View view){
//        Button: "PLACE NEW ORDER" to Layout: activity_edit_order
        Intent intent = new Intent(this, editOrder.class);
        startActivity(intent);

    }

    public void onClickSeeOrders(View view){
//        Button: "SEE ORDERS" to Layout: activity_show_orders
        Intent intent = new Intent(this, showOrders.class);
        startActivity(intent);
    }
}
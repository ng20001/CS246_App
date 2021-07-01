package com.example.cs246_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> orders;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickAddOrder(View view){
        Intent intent = new Intent(this, editOrder.class);
        startActivity(intent);
        int Min = 1;
        int Max = 100;
        int val = Min + (int)(Math.random()*((Max - Min)+1));
        String random = String.valueOf(val);
        orders.add(random);
    }

    public void onClickDisplayOrder(View view){
        Intent intent = new Intent(this, backOfHouse.class);
        startActivity(intent);

        // Create Json string
        String jsonFileString = Menu.getJsonFromAssets(getApplicationContext(), "menu.json");
        // Display Json string on console
        Log.i("data", jsonFileString);

        Gson gson = new Gson();
        Type listMenuType = new TypeToken<List<MenuItem>>() { }.getType();


        List<MenuItem> menu = gson.fromJson(jsonFileString, listMenuType);
        for (int i = 0; i < menu.size(); i++) {
            Log.i("data", "> Item " + i + "\n" + menu.get(i));
        }

    }

    public void onClickPayOrder(View view){
        Intent intent = new Intent(this, payOrder.class);
        startActivity(intent);

    }

}
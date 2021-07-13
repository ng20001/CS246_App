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
            Log.wtf("MainActivity", "An error ocurred");
        }
    }


    public void onClickAddOrder(View view){
        Intent intent = new Intent(this, editOrder.class);
        startActivity(intent);

    }

    public void onClickDisplayOrder(View view){
        // Create Json string
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

        Intent intent = new Intent(this, backOfHouse.class);

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("MENU", (ArrayList<? extends Parcelable>) menu);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    public void onClickSeeOrders(View view){
        Intent intent = new Intent(this, showOrders.class);
        startActivity(intent);
    }
//adding comments
}
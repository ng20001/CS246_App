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
import java.util.List;

public class showOrders extends AppCompatActivity {
    ShowAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_orders);

        Bundle bundle = getIntent().getExtras();
        //ArrayList<MenuItem> arraylist = bundle.getParcelableArrayList("MENU");

        //set the adapter
        RecyclerView view = findViewById(R.id.recycler_show_orders);

        adapter = new ShowAdapter(this, new ArrayList<>(MainActivity.INSTANCE.orders.keySet()));
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        RecyclerView view = findViewById(R.id.recycler_show_orders);
        adapter = new ShowAdapter(this, new ArrayList<>(MainActivity.INSTANCE.orders.keySet()));
        adapter.setClickListener(new ShowAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                adapter.getItem(position);
            }
        });
        view.setAdapter(adapter);
    }

    /*public void onClickDisplayOrder(View view){
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
    }*/
}

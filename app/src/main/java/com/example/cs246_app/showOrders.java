package com.example.cs246_app;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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
}

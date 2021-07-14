package com.example.cs246_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class backOfHouse extends AppCompatActivity {
    DisplayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_of_house);

        Bundle bundle = getIntent().getExtras();
        //change line to getExtra and change list to Map
        //transform map into list
        //and give the list to the adpater
        ArrayList<MenuItem> arraylist = bundle.getParcelableArrayList("MENU");

        //set the adapter
        RecyclerView view = findViewById(R.id.recycler_display_orders);
        adapter = new DisplayAdapter(this, arraylist);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
    }
    //adding comments
    public void onClickDone(View view){
        finish();
    }
}
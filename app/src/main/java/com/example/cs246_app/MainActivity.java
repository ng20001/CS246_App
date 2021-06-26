package com.example.cs246_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAddOrder(View view){
        Intent intent = new Intent(this, editOrder.class);
        startActivity(intent);

    }

    public void onClickDisplayOrder(View view){
        Intent intent = new Intent(this, backOfHouse.class);
        startActivity(intent);

    }
}
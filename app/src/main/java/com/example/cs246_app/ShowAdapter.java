package com.example.cs246_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder>{
    private List<String> mData;
    private LayoutInflater mInflater;
    private static ShowAdapter.ItemClickListener mClickListener;

    // data is passed into the constructor
    ShowAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ShowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_show_orders, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ShowAdapter.ViewHolder holder, int position) {
        String animal = mData.get(position);
        holder.myTextView.setText(animal);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }




    // stores and recycles views as they are scrolled off screen
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        View row;
        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.orderID);
            itemView.setOnClickListener(this);
            row = itemView;
        }

        public void displayID(View view){
            //find view by id
            EditText text = row.findViewById(R.id.orderID);

            //text.setText(String.valueOf(orders));

        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
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

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ShowAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = (ItemClickListener) itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
    //adding comments
}

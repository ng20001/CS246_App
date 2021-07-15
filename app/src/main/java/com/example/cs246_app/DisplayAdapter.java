package com.example.cs246_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.ViewHolder> {
    private ArrayList<String> foodItems;
    private ArrayList<Integer> foodQtys;
//    private HashMap<String, Integer> mData;
    private LayoutInflater mInflater;
    private DisplayAdapter.ItemClickListener mClickListener;

    // data is passed into the constructor
//    DisplayAdapter(Context context, List<MenuItem> data) {
    DisplayAdapter(Context context, ArrayList<String> foodItems, ArrayList<Integer> foodQtys) {
        this.mInflater = LayoutInflater.from(context);
//        this.mData = data;
        this.foodItems = foodItems;
        this.foodQtys = foodQtys;
    }

    // inflates the row layout from xml when needed
    @Override
    public DisplayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = mInflater.inflate(R.layout.row_display_order, parent, false);
        return new DisplayAdapter.ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(DisplayAdapter.ViewHolder holder, int position) {

        // Take 2 arrays and get the desired item in the arrays by position
        holder.foodItem.setText(String.valueOf(foodItems.get(position)));
        holder.qty.setText(String.valueOf(foodQtys.get(position)));
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return foodItems.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        EditText foodItem;
        EditText qty;
        View row;
        ViewHolder(View itemView) {
            super(itemView);
            foodItem = itemView.findViewById(R.id.foodItem);
            qty = itemView.findViewById(R.id.qty);
            itemView.setOnClickListener(this);  
            row = itemView;
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return String.valueOf(foodItems.get(id));
    }

    // allows clicks events to be caught
    void setClickListener(DisplayAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
    //adding comments
}


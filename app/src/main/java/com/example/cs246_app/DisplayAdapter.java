package com.example.cs246_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;

public class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.ViewHolder> {

    private HashMap<String, Integer> mData;
    private LayoutInflater mInflater;
    private DisplayAdapter.ItemClickListener mClickListener;

    // data is passed into the constructor
//    DisplayAdapter(Context context, List<MenuItem> data) {
    DisplayAdapter(Context context, HashMap<String, Integer> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
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
//        HashMap<String, Integer> menu = mData.get(position);
        System.out.println("'position'");
        System.out.println(position);
        System.out.println("'mData.entrySet()'");
        System.out.println(mData.entrySet());
        System.out.println("'mData.keySet()'");
        System.out.println(mData.keySet());

        holder.foodItem.setText("food item here");
        holder.qty.setText("qty here");
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        EditText foodItem;
        EditText qty;
        View row;
        ViewHolder(View itemView) {
            super(itemView);
            foodItem = itemView.findViewById(R.id.foodItemDisplay2);
            qty = itemView.findViewById(R.id.quantityBtn2);
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
        return String.valueOf(mData.get(id));
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


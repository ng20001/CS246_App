package com.example.cs246_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DisplayAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    private OrderAdapter.ItemClickListener mClickListener;

    // data is passed into the constructor
    DisplayAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_edit_order, parent, false);
        return new OrderAdapter.ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(OrderAdapter.ViewHolder holder, int position) {
        String animal = mData.get(position);
        holder.myTextView.setText(animal);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        View row;
        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.foodItemDisplay2);
            itemView.setOnClickListener(this);
            row = itemView;
            Button add = row.findViewById(R.id.buttonAdd);
            Button decrease = row.findViewById(R.id.buttonDecrease);
            add.setOnClickListener(this::addItem);
            decrease.setOnClickListener(this::decreaseItem);
        }
        int item = 0;
        public void addItem(View view){
            item++;
            displayQuantity();
        }

        public void decreaseItem(View view){
            if (item > 0){
                item--;
            }
            else{
                item = 0;
            }

            displayQuantity();
        }

        public void displayQuantity(){
            //find view by id
            EditText text = row.findViewById(R.id.quantityBtn);
            //set text to it
            text.setText(String.valueOf(item));

        }
        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(OrderAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}


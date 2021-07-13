package com.example.cs246_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    //takes the information and put it into the recycler

    private final List<MenuItem> mData;
    private final LayoutInflater mInflater;
    private static ItemClickListener mClickListener;

    // data is passed into the constructor
    OrderAdapter(Context context, List<MenuItem> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_edit_order, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MenuItem menu = mData.get(position);
        holder.myTextView.setText(menu.getFoodItem());
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
            myTextView = itemView.findViewById(R.id.foodItemDisplay2);
            itemView.setOnClickListener(this);
            row = itemView;
            Button add = row.findViewById(R.id.buttonAdd);
            Button decrease = row.findViewById(R.id.buttonDecrease);

            // On click listeners
            add.setOnClickListener(this::addItem);
            decrease.setOnClickListener(this::decreaseItem);
        }

        // Clicks behavior
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

        // Show qty
        public void displayQuantity(){
            //find view by id
            EditText text = row.findViewById(R.id.quantityBtn3);
            //set text to it
            text.setText(String.valueOf(item));

        }
        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    MenuItem getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
    //adding comments
}


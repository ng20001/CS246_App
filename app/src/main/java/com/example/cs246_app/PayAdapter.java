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

public class PayAdapter extends RecyclerView.Adapter<PayAdapter.ViewHolder> {
    private List<String> mData;
    private LayoutInflater mInflater;
    private PayAdapter.ItemClickListener mClickListener;

    // data is passed into the constructor
    PayAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public PayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_pay_order, parent, false);
        return new PayAdapter.ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(PayAdapter.ViewHolder holder, int position) {
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
            myTextView = itemView.findViewById(R.id.foodItemDisplay3);
            itemView.setOnClickListener(this);
            row = itemView;

        }
        int item = 0;

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
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(PayAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

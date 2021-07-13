package com.example.cs246_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class PayAdapter extends RecyclerView.Adapter<PayAdapter.ViewHolder> {
    private List<Map.Entry<MenuItem, Integer>> mData;
    private LayoutInflater mInflater;
    private PayAdapter.ItemClickListener mClickListener;

    // data is passed into the constructor
    PayAdapter(Context context, List<Map.Entry<MenuItem, Integer>> data) {
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
        Map.Entry<MenuItem, Integer> entry = mData.get(position);
        holder.foodItem.setText(entry.getKey().foodItem);
        holder.qty.setText(String.valueOf(entry.getValue()));
        holder.cost.setText(String.valueOf(entry.getKey().cost * entry.getValue()));
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView foodItem, cost, qty;

        View row;
        ViewHolder(View itemView) {
            super(itemView);
            foodItem = itemView.findViewById(R.id.foodItemDisplay3);
            cost = itemView.findViewById(R.id.moneyAmount);
            qty = itemView.findViewById(R.id.quantityBtn3);

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
    Map.Entry <MenuItem, Integer> getItem(int id) {
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
    //adding comments
}

package com.example.cs246_app;
import android.os.Parcel;
import android.os.Parcelable;

public class MenuItem implements Parcelable {
    String foodItem;
    double cost;

    protected MenuItem(Parcel in) {
        foodItem = in.readString();
        cost = in.readDouble();
    }

    public static final Creator<MenuItem> CREATOR = new Creator<MenuItem>() {
        @Override
        public MenuItem createFromParcel(Parcel in) {
            return new MenuItem(in);
        }

        @Override
        public MenuItem[] newArray(int size) {
            return new MenuItem[size];
        }
    };

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "\nname: " + foodItem + "; price: " + cost;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(foodItem);
        dest.writeDouble(cost);
    }
    //adding comments
}

package com.example.cs246_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.internal.DiskLruCache;

import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static MainActivity INSTANCE = null;
    //Map<NameClient, Map<Map.Entry<MenuItem, quantity, price>
    public static Map<String, Map<Map.Entry<MenuItem, Integer>, Integer>> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (INSTANCE == null) {
            INSTANCE = this;
            MainActivity.orders = new HashMap<String, Map<Map.Entry<MenuItem, Integer>, Integer>>();
            String TAG ="main";
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            final CollectionReference docRef = db.collection("orders");
            docRef.addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot snapshot,
                                    @Nullable FirebaseFirestoreException e) {
                    if (e != null) {
                        Log.w(TAG, "Listen failed.", e);
                        return;
                    }

                    if (snapshot != null && !snapshot.isEmpty()) {

                        Log.d(TAG, "Current data: " + snapshot.getDocuments());
                        MainActivity.orders.clear();
                        for(DocumentSnapshot order : snapshot.getDocuments()){

                            Map <String, Object> orderDetails = order.getData();;
                            String name = (String) orderDetails.get("name");
                            Map<String, Long> orderItems = (Map<String, Long>) orderDetails.get("orderItems");

                            // Get Json File from Menu class
                            String jsonFileString = Menu.getJsonFromAssets(getApplicationContext(), "menu.json");
                            // Display Json string on console
                            assert jsonFileString != null;
                            //        Log.i("data", jsonFileString);

                            Gson gson = new Gson();
                            Type listMenuType = new TypeToken<List<MenuItem>>() { }.getType();

                            //Assign list from json file
                            List<MenuItem> menu = gson.fromJson(jsonFileString, listMenuType);

                            Map<Map.Entry<MenuItem, Integer>, Integer>orderCreated = new HashMap<>();
                            for(Map.Entry<String, Long> item : orderItems.entrySet()){
                                String nameOfItem = item.getKey();
                                for(MenuItem menuItem :menu){
                                    if(menuItem.getFoodItem().equals(nameOfItem)){
                                        orderCreated.put(new AbstractMap.SimpleEntry<MenuItem, Integer>(menuItem, item.getValue().intValue()),item.getValue().intValue());
                                        break;
                                    }
                                }
                            }
                            MainActivity.orders.put(name, orderCreated);
                        }
                    } else {
                        Log.d(TAG, "Current data: null");
                    }
                }
            });
        } else {
            //throw error
           // Log.wtf("MainActivity", "An error occurred");
        }

    }

    public void onClickAddOrder(View view){
//        Button: "PLACE NEW ORDER" to Layout: activity_edit_order
        Intent intent = new Intent(this, editOrder.class);
        startActivity(intent);

    }

    public void onClickSeeOrders(View view){
//        Button: "SEE ORDERS" to Layout: activity_show_orders
        Intent intent = new Intent(this, showOrders.class);
        System.out.println("Entering show order lists");
        startActivity(intent);
    }
}
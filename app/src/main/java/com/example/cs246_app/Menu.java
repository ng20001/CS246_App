package com.example.cs246_app;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.lang.reflect.Type;
import java.util.List;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class Menu{
    static String getJsonFromAssets(Context context, String fileName) {
        String jsonString;
        try {
            // Open a file in assets folder
            // returns an InputStream
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];

            // use InputStream.read() to read data into byte buffer
            // transform the buffer into a String
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return jsonString;
    }
    //adding comments
}

package com.example.lukasz.arrangemeetingsclient;

import android.app.Application;
import android.content.SharedPreferences;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lukasz on 04.09.17.
 */

public class ArrangeMeetings extends Application {

    private static final String BASE_URL = "http://192.168.0.31";
    SharedPreferences sharedPreferences;

    Retrofit retrofit;
    public static ApiInterface apiInterface;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences = getSharedPreferences("com.example.lukasz.arrangemeetingsclient", MODE_PRIVATE);
        String baseUrl = BASE_URL;
        if (sharedPreferences.getString("setting.apiUrl", "") != "") {
            baseUrl = sharedPreferences.getString("setting.apiUrl", BASE_URL).toString();
        }
        retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        apiInterface = retrofit.create(ApiInterface.class);
    }
}

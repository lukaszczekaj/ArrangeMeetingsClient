package com.example.lukasz.arrangemeetingsclient;

import android.app.Application;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lukasz on 04.09.17.
 */

public class ArrangeMeetings extends Application {

    private static final String BASE_URL = "http://192.168.0.31/";
    SharedPreferences sharedPreferences;

    Retrofit retrofit;
    Retrofit retrofitSend;
    public static ApiInterface apiInterface;
    public static ApiInterface apiInterfaceSend;

    @Override
    public void onCreate() {
        super.onCreate();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        sharedPreferences = getSharedPreferences("com.example.lukasz.arrangemeetingsclient", MODE_PRIVATE);
        String baseUrl = sharedPreferences.getString("setting.apiUrl", BASE_URL).toString();
        retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        retrofitSend = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create(gson)).build();
        apiInterface = retrofit.create(ApiInterface.class);
        apiInterfaceSend = retrofitSend.create(ApiInterface.class);
    }

}

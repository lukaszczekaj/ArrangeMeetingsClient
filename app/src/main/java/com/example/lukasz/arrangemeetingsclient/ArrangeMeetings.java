package com.example.lukasz.arrangemeetingsclient;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lukasz on 04.09.17.
 */

public class ArrangeMeetings extends Application {

    private static final String BASE_URL = "http://192.168.0.31/";

    Retrofit retrofit;
    public static ApiInterface apiInterface;

    @Override
    public void onCreate() {
        super.onCreate();
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();


        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiInterface = retrofit.create(ApiInterface.class);
    }
}

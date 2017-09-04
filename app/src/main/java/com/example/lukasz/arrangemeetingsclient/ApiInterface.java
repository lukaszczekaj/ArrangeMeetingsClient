package com.example.lukasz.arrangemeetingsclient;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by lukasz on 04.09.17.
 */

public interface ApiInterface {
    @GET("/company-list")
    Call<JsonArray> getCompanyList();
}

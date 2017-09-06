package com.example.lukasz.arrangemeetingsclient;

import com.example.lukasz.arrangemeetingsclient.api.Metting;
import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by lukasz on 04.09.17.
 */

public interface ApiInterface {

    @GET("/company-list")
    Call<JsonArray> getCompanyList();

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET("/receiving-customers-date/{id}")
    Call<JsonArray> getReceivingCustomersDate(@Path("id") String id);

    @POST("/save-metting")
    Call<String> saveMetting(@Body Metting metting);

}

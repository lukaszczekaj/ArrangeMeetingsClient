package com.example.lukasz.arrangemeetingsclient.api;

/**
 * Created by lukasz on 06.09.17.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {

    @SerializedName("code")
    @Expose
    public Long code;
    @SerializedName("message")
    @Expose
    public String message;

}

package com.example.lukasz.arrangemeetingsclient.api;

/**
 * Created by lukasz on 04.09.17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("pass")
    @Expose
    public String pass;
    @SerializedName("addressstreet")
    @Expose
    public String addressstreet;
    @SerializedName("addresscity")
    @Expose
    public String addresscity;
    @SerializedName("addresspostalcode")
    @Expose
    public String addresspostalcode;
    @SerializedName("id")
    @Expose
    public Long id;

}

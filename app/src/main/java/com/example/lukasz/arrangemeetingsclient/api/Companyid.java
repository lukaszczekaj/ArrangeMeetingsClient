package com.example.lukasz.arrangemeetingsclient.api;

/**
 * Created by lukasz on 06.09.17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Companyid {

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
    @SerializedName("imgurl")
    @Expose
    public String imgurl;
    @SerializedName("id")
    @Expose
    public Long id;

}

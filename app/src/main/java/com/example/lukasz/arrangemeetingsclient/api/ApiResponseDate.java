package com.example.lukasz.arrangemeetingsclient.api;

/**
 * Created by lukasz on 06.09.17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponseDate {

    @SerializedName("timefrom")
    @Expose
    public String timefrom;
    @SerializedName("timeto")
    @Expose
    public String timeto;
    @SerializedName("id")
    @Expose
    public Long id;
    @SerializedName("companyid")
    @Expose
    public Companyid companyid;

}

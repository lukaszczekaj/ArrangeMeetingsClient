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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAddressstreet() {
        return addressstreet;
    }

    public void setAddressstreet(String addressstreet) {
        this.addressstreet = addressstreet;
    }

    public String getAddresscity() {
        return addresscity;
    }

    public void setAddresscity(String addresscity) {
        this.addresscity = addresscity;
    }

    public String getAddresspostalcode() {
        return addresspostalcode;
    }

    public void setAddresspostalcode(String addresspostalcode) {
        this.addresspostalcode = addresspostalcode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

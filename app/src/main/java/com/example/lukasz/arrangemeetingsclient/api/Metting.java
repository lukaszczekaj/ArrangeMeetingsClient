package com.example.lukasz.arrangemeetingsclient.api;

import org.parceler.Parcel;

/**
 * Created by lukasz on 06.09.17.
 */

@Parcel
public class Metting {

    private String mail;
    private Integer companyID;
    private String phone;
    private String firstName;
    private String lastName;
    private String dateFrom;
    private String dateTo;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer timeFromHour;
    private Integer timeFromMinute;
    private Integer timeToHour;
    private Integer timeToMinute;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getTimeFromHour() {
        return timeFromHour;
    }

    public void setTimeFromHour(Integer timeFromHour) {
        this.timeFromHour = timeFromHour;
    }

    public Integer getTimeFromMinute() {
        return timeFromMinute;
    }

    public void setTimeFromMinute(Integer timeFromMinute) {
        this.timeFromMinute = timeFromMinute;
    }

    public Integer getTimeToHour() {
        return timeToHour;
    }

    public void setTimeToHour(Integer timeToHour) {
        this.timeToHour = timeToHour;
    }

    public Integer getTimeToMinute() {
        return timeToMinute;
    }

    public void setTimeToMinute(Integer timeToMinute) {
        this.timeToMinute = timeToMinute;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}

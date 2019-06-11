package com.example.android.quakereport;

import java.util.Date;

public class Earthquake {
    String mag;
    String place;
    String date;

    public Earthquake(String mag, String place, String date) {
        this.mag = mag;
        this.place = place;
        this.date = date;
    }

    public String getMag() {
        return mag;
    }

    public String getPlace() {
        return place;
    }

    public String getDate() {
        return date;
    }
}

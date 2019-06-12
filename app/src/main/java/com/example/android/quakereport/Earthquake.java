package com.example.android.quakereport;

public class Earthquake {
    private String mag;
    private String place;
    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    public Earthquake(String mag, String place, long mTimeInMilliseconds) {
        this.mag = mag;
        this.place = place;
        this.mTimeInMilliseconds = mTimeInMilliseconds;
    }

    public String getMag() {
        return mag;
    }

    public String getPlace() {
        return place;
    }

    /**
     * Returns the time of the earthquake.
     */
    public long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}

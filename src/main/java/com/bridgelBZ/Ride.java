package com.bridgelBZ;

import java.util.HashMap;

public class Ride {
    private double distance;
    private double time;
    private int user_id;

    public Ride(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }



    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }


}

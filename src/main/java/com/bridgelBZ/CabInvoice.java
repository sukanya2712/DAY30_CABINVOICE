package com.bridgelBZ;

public class CabInvoice {
    public static final int COST_PER_KILOMETER = 10;
    public static final int COST_PER_MINUTE = 1;
    public static final int MINIMUM_FARE = 5;


    public double calculateFare(double distance, double time) {
        double fare = (distance * COST_PER_KILOMETER) + (time * COST_PER_MINUTE);
        return (fare < MINIMUM_FARE)? MINIMUM_FARE : fare;
    }
}

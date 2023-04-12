package com.bridgelBZ;

public class CabInvoice {
    //uc1
    public static final int COST_PER_KILOMETER = 10;
    public static final int COST_PER_MINUTE = 1;
    public static final int MINIMUM_FARE = 5;


    public double calculateFare(double distance, double time) {
        double fare = (distance * COST_PER_KILOMETER) + (time * COST_PER_MINUTE);
        return (fare < MINIMUM_FARE)? MINIMUM_FARE : fare;
    }

    //uc2
    public double calculateFare(Ride[] rides) {
        double aggregateFare = 0;
        for (Ride ride: rides) {
            aggregateFare += calculateFare(ride.getDistance(),ride.getTime());
        }
        return aggregateFare;
    }

    //uc3
    public Invoice generateInvoice(Ride[] rides) {
        int totalRides = rides.length;
        double totalFare = calculateFare(rides);
        double averageFare =(totalFare/totalRides);
        return new Invoice(totalRides,totalFare,averageFare);
    }
    //uc4

}

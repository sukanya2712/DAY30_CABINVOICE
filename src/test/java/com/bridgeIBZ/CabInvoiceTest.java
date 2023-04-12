package com.bridgeIBZ;

import com.bridgelBZ.CabInvoice;
import com.bridgelBZ.Invoice;
import com.bridgelBZ.Ride;
import com.bridgelBZ.RideRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class CabInvoiceTest {
    //uc1
    CabInvoice cabInvoice;

    @BeforeEach
    public void init(){
        cabInvoice = new CabInvoice();
    }

    @Test
    public void givenDistanceAndTimeShouldReturnTotalFare(){
        double fare = cabInvoice.calculateFare(20,5);
        Assertions.assertEquals(205,fare,0.0);
    }

    @Test
    public void givenDistanceAndTimeShouldReturnMinimumFare(){
        double fare = cabInvoice.calculateFare(0.2,1);
        Assertions.assertEquals(5,fare,0.0);
    }
    //uc2
    @Test
    public void givenMultipleRidesShouldReturnAggregateFare(){
        Ride ride1 = new Ride(20,5);
        Ride ride2 = new Ride(0.2,1);
        Ride ride3 = new Ride(0.5,2);
        Ride ride4 = new Ride(10,5);
        Ride[] rides = {ride1,ride2,ride3,ride4};
        double aggregateFare = cabInvoice.calculateFare(rides);
        Assertions.assertEquals(322,aggregateFare);
    }

    //uc3
    @Test
    public void givenMultipleRidesShouldReturnInvoice(){
        Ride ride1 = new Ride(20,5);
        Ride ride2 = new Ride(0.2,1);
        Ride ride3 = new Ride(0.5,2);
        Ride ride4 = new Ride(10,5);
        Ride[] rides = {ride1,ride2,ride3,ride4};
        Invoice expectedInvoice = new Invoice(4,322.0,322.0/4);
        Invoice invoice = cabInvoice.generateInvoice(rides);
        Assertions.assertEquals(expectedInvoice,invoice);
    }
    //uc4
    @Test
    public void givenUserShouldReturnInvoice(){
        RideRepository repository = new RideRepository();
        Ride ride1 = new Ride(20,5);
        Ride ride2 = new Ride(0.2,1);
        Ride ride3 = new Ride(0.5,2);
        Ride ride4 = new Ride(10,5);
        Ride[] rides1 = {ride1,ride2};
        Ride[] rides2 = {ride3,ride4};
        repository.addRides("user101",rides1);
        repository.addRides("user102",rides2);
        Invoice actualInvoice1 = repository.getInvoiceFromUserId("user102");
        Invoice actualInvoice2 = repository.getInvoiceFromUserId("user101");
        Invoice expectedInvoice1 = new Invoice(2,112,56);
        Invoice expectedInvoice2 = new Invoice(2,210,105);
        Assertions.assertEquals(expectedInvoice1,actualInvoice1);
        Assertions.assertEquals(expectedInvoice2,actualInvoice2);
    }
}

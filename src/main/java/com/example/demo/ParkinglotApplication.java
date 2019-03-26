package com.example.demo;

import com.example.demo.Parkings.ParkingFloor;
import com.example.demo.Parkings.ParkingLot;
import com.example.demo.Vehicles.Vehicle;
import com.example.demo.Vehicles.VehicleType;


public class ParkinglotApplication {

    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getParkingLot();

        ParkingFloor parkingFloor = new ParkingFloor();
        parkingLot.addParkingFloor(parkingFloor);

        Vehicle vehicle = new Vehicle.Car(VehicleType.CAR);
        parkingLot.takeTicket(vehicle);


        parkingLot.payTicketAmount(vehicle);
    }

}

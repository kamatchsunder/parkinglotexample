package com.example.demo.Parkings;

import com.example.demo.Tickets.Ticket;
import com.example.demo.Vehicles.Vehicle;
import com.example.demo.Vehicles.VehicleType;

import java.util.HashMap;


public class ParkingLot {

    private int carParkingSpotCount = 0;
    private int twoWheelerParkingSpotCount = 0;
    private HashMap<Integer, ParkingFloor> parkingFloorHashMap = new HashMap<>();

    private static ParkingLot parkingLot = new ParkingLot();


    private ParkingLot() {

    }


    public static ParkingLot getParkingLot() {

        return parkingLot;
    }


    public void addParkingFloor(ParkingFloor parkingFloor) {

        parkingFloorHashMap.put(parkingFloor.getNumber(), parkingFloor);
    }


    public Ticket takeTicket(Vehicle vehicle) {

        Ticket ticket = new Ticket();
        vehicle.assignTicket(ticket);

        switch (vehicle.getVehicleType()) {
        case CAR:
            carParkingSpotCount++;
        case TWO_WHEELER:
            twoWheelerParkingSpotCount++;
        }

        assignSpotToVehicle(vehicle);

        return ticket;
    }


    private void assignSpotToVehicle(Vehicle vehicle) {

        parkingFloorHashMap.forEach((key, value) -> {

            if (vehicle.getVehicleType() == VehicleType.CAR) {
                value.addParkingSpot(new ParkingSpot.CarParkingSpot(ParkingSpotType.CAR_PARKING));
            }
            else if (vehicle.getVehicleType() == VehicleType.TWO_WHEELER) {
                value.addParkingSpot(new ParkingSpot.TwoWheelerParkingSpot(ParkingSpotType.TWO_WHEELER_PARKING));
            }
        });
    }

}

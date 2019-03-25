package com.example.demo.Parkings;

import com.example.demo.Vehicles.Vehicle;

import java.util.HashMap;


public class ParkingFloor {

    private int number;

    private DisplayBoard displayBoard;

    private HashMap<Integer, ParkingSpot> carParkingSpotHashMap = new HashMap<>();
    private HashMap<Integer, ParkingSpot> twoWheelerParkingSpotHashMap = new HashMap<>();


    public void addParkingSpot(ParkingSpot parkingSpot) {

        switch (parkingSpot.getParkingSpotType()) {

        case CAR_PARKING:
            carParkingSpotHashMap.put(parkingSpot.getNumber(), parkingSpot);
        case TWO_WHEELER_PARKING:
            twoWheelerParkingSpotHashMap.put(parkingSpot.getNumber(), parkingSpot);
        }
    }


    public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot parkingSpot) {

        parkingSpot.assignVehicle(vehicle);
    }


    public void removeVehicleFromSpot(Vehicle vehicle, ParkingSpot parkingSpot) {

        parkingSpot.removeVehicle();
    }


    public int getNumber() {

        return number;
    }
}

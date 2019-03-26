package com.example.demo.Parkings;

import com.example.demo.Vehicles.Vehicle;
import com.example.demo.Vehicles.VehicleType;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;


public class ParkingFloor {

    private int number;

    private DisplayBoard displayBoard;

    private ConcurrentHashMap<Integer, ParkingSpot> carParkingSpotHashMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, ParkingSpot> twoWheelerParkingSpotHashMap = new ConcurrentHashMap<>();


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

    public ParkingSpot getParkingSpot(Vehicle vehicle){

        if (vehicle.getVehicleType() == VehicleType.CAR) {
            return carParkingSpotHashMap.entrySet().stream()
                    .filter(integerParkingSpotEntry -> integerParkingSpotEntry.getValue().getVehicle().getNumber().equals
                            (vehicle.getNumber()))
                    .map(integerParkingSpotEntry -> integerParkingSpotEntry.getValue())
                    .findFirst().get();

        }
        else if (vehicle.getVehicleType() == VehicleType.TWO_WHEELER) {

            return twoWheelerParkingSpotHashMap.entrySet().stream()
                    .filter(integerParkingSpotEntry -> integerParkingSpotEntry.getValue().getVehicle().getNumber().equals
                            (vehicle.getNumber()))
                    .map(integerParkingSpotEntry -> integerParkingSpotEntry.getValue())
                    .findFirst().get();
        }
        return null;
    }


    public int getNumber() {

        return number;
    }
}

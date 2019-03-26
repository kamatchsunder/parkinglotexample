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


    public double payTicketAmount(Vehicle vehicle){

        for(int number : parkingFloorHashMap.keySet()){
            ParkingFloor parkingFloor = parkingFloorHashMap.get(number);

            ParkingSpot parkingSpot = parkingFloor.getParkingSpot(vehicle);
            double amount = vehicle.getTicket().getPayAmount();
            parkingFloor.removeVehicleFromSpot(vehicle,parkingSpot);
            return amount;
        }

        return 0.0;
    }


    private void assignSpotToVehicle(Vehicle vehicle) {


        for(int number : parkingFloorHashMap.keySet()){
            ParkingFloor parkingFloor = parkingFloorHashMap.get(number);
            if (vehicle.getVehicleType() == VehicleType.CAR) {
                ParkingSpot parkingSpot = new ParkingSpot.CarParkingSpot(ParkingSpotType.CAR_PARKING);
                parkingFloor.assignVehicleToSpot(vehicle,parkingSpot);
                parkingFloor.addParkingSpot(parkingSpot);
                break;
            }
            else if (vehicle.getVehicleType() == VehicleType.TWO_WHEELER) {
                ParkingSpot parkingSpot = new ParkingSpot.TwoWheelerParkingSpot(ParkingSpotType.TWO_WHEELER_PARKING);
                parkingFloor.assignVehicleToSpot(vehicle,parkingSpot);
                parkingFloor.addParkingSpot(parkingSpot);
                break;
            }
        }
    }

}

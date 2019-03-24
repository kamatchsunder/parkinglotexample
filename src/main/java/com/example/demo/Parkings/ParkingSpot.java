package com.example.demo.Parkings;

import com.example.demo.Vehicles.Vehicle;


public abstract class ParkingSpot {

    public int getNumber() {

        return number;
    }


    private int number;
    private Vehicle vehicle;
    private boolean isFree=true;

    private ParkingSpotType parkingSpotType;

    public ParkingSpot(ParkingSpotType parkingSpotType){
        this.parkingSpotType = parkingSpotType;
    }

    public void assignVehicle(Vehicle vehicle){

        this.vehicle = vehicle;
        isFree = false;
    }

    public boolean removeVehicle(){
        this.vehicle = null;
        isFree = true;
        return isFree = false;
    }

    public boolean isFree() {

        return isFree;
    }


    public ParkingSpotType getParkingSpotType() {

        return parkingSpotType;
    }


    public class CarParkingSpot extends ParkingSpot {

        public CarParkingSpot(ParkingSpotType parkingSpotType) {

            super(ParkingSpotType.CAR_PARKING);
        }
    }


    public  class TwoWheelerParkingSpot extends  ParkingSpot {

        public TwoWheelerParkingSpot(ParkingSpotType parkingSpotType) {

            super(ParkingSpotType.TWO_WHEELER_PARKING);
        }
    }
}

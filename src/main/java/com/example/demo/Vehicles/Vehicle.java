package com.example.demo.Vehicles;

import com.example.demo.Tickets.Ticket;


public abstract class Vehicle {

    public String getNumber() {

        return number;
    }


    private String number;


    public VehicleType getVehicleType() {

        return vehicleType;
    }


    private VehicleType vehicleType;
    private Ticket ticket;


    public Vehicle(VehicleType vehicleType){

        this.vehicleType = vehicleType;
    }


    public void assignTicket(Ticket ticket){

        this.ticket = ticket;
    }


    public class Car extends Vehicle {

        public Car(VehicleType vehicleType) {

            super(VehicleType.CAR);
        }
    }

    public class TwoWheeler extends  Vehicle {

        public TwoWheeler(VehicleType vehicleType) {

            super(VehicleType.TWO_WHEELER);
        }
    }

}

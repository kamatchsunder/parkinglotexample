package com.example.demo.Vehicles;

import com.example.demo.Tickets.Ticket;

import java.util.Random;


public abstract class Vehicle {

    private String number;

    private VehicleType vehicleType;


    public Ticket getTicket() {

        return ticket;
    }


    private Ticket ticket;


    public Vehicle(String number,VehicleType vehicleType){

        this.number = number;
        this.vehicleType = vehicleType;
    }


    public void assignTicket(Ticket ticket){

        this.ticket = ticket;
    }


    public static class Car extends Vehicle {

        public Car(VehicleType vehicleType) {

            super(Math.random()+"",VehicleType.CAR);
        }
    }

    public class TwoWheeler extends  Vehicle {

        public TwoWheeler(VehicleType vehicleType) {

            super(Math.random()+"",VehicleType.TWO_WHEELER);
        }
    }

    public String getNumber() {

        return number;
    }

    public VehicleType getVehicleType() {

        return vehicleType;
    }

}

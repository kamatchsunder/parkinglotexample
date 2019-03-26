package com.example.demo.Tickets;

import java.util.Date;


public class Ticket {

    private String ticketNumber;


    public String getTicketNumber() {

        return ticketNumber;
    }


    public void setTicketNumber(String ticketNumber) {

        this.ticketNumber = ticketNumber;
    }


    public long getInTime() {

        return inTime;
    }


    public void setInTime(long inTime) {

        this.inTime = inTime;
    }


    public Date getParkingDate() {

        return parkingDate;
    }


    public void setParkingDate(Date parkingDate) {

        this.parkingDate = parkingDate;
    }


    public double getPayAmount() {

        return payAmount;
    }


    public void setPayAmount(double payAmount) {

        this.payAmount = payAmount;
    }


    public boolean isParkingTicketStatus() {

        return parkingTicketStatus;
    }


    public void setParkingTicketStatus(boolean parkingTicketStatus) {

        this.parkingTicketStatus = parkingTicketStatus;
    }


    private long inTime;
    private Date parkingDate;
    private double payAmount;
    private boolean parkingTicketStatus;
}

package com.example.taxi.booking_management;

import com.example.taxi.vehicle_management.Vehicle;

public class booking {
    String fullName;
    String phoneNum;
    String date;
    String time;
    String from;
    String to;
    String Vehicle;

    public booking(String fullName, String phoneNum, String date, String time, String from, String to, String Vehicle) {
        this.fullName = fullName;
        this.phoneNum = phoneNum;
        this.date = date;
        this.time = time;
        this.from = from;
        this.to = to;
        this.Vehicle = Vehicle;
    }

    public booking() {
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }

    public String gettime() {
        return time;
    }

    public void settime(String time) {
        this.time = time;
    }

    public String getfrom() {
        return from;
    }

    public void setfrom(String from) {
        this.from = from;
    }

    public String getto() {
        return  to;
    }

    public void setto(String to) {
        this.to = to;
    }


    public String getVehicle() {
        return   Vehicle;
    }

    public void setVehicle(String Vehicle) {
        this.Vehicle = Vehicle;
    }



}

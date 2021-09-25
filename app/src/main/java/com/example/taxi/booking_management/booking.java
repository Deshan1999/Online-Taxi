package com.example.taxi.booking_management;

public class booking {
    String fullName;
    String phoneNum;
    String date;
    String time;
    String from;
    String to;

    public booking(String fullName, String phoneNum, String date, String time, String from, String to) {
        this.fullName = fullName;
        this.phoneNum = phoneNum;
        this.date = date;
        this.time = time;
        this.from = from;
        this.to = to;
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


}

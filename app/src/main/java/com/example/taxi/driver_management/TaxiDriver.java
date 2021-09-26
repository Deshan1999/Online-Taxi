package com.example.taxi.driver_management;

public class TaxiDriver {
    String username;
    String email;
    String password;
    String address;
    String phoneno;
    String vehiclenumber;

    public TaxiDriver(String username, String email, String password, String address, String phoneno, String vehiclenumber) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneno = phoneno;
        this.vehiclenumber = vehiclenumber;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getVehiclenumber() {
        return vehiclenumber;
    }

    public void setVehiclenumber(String vehiclenumber) {
        this.vehiclenumber = vehiclenumber;
    }

}


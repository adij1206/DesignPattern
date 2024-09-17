package com.aditya.DesignPattern.lld.carReservationSystem;

public class User {

    private String userId;
    private String userName;
    private String licenseNumber;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public User(String userId, String userName, String licenseNumber) {
        this.userId = userId;
        this.userName = userName;
        this.licenseNumber = licenseNumber;
    }
}

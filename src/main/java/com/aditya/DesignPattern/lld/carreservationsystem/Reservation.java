package com.aditya.DesignPattern.lld.carreservationsystem;

public class Reservation {

    private String id;
    private Vehicle vehicle;
    private User user;
    private Long bookingDate;
    private Long fromTimeStamp;
    private Long toTimeStamp;
    private ReservationStatus status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Long bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Long getFromTimeStamp() {
        return fromTimeStamp;
    }

    public void setFromTimeStamp(Long fromTimeStamp) {
        this.fromTimeStamp = fromTimeStamp;
    }

    public Long getToTimeStamp() {
        return toTimeStamp;
    }

    public void setToTimeStamp(Long toTimeStamp) {
        this.toTimeStamp = toTimeStamp;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public Reservation(
            String id, Vehicle vehicle, User user, Long bookingDate, Long fromTimeStamp, Long toTimeStamp,
            ReservationStatus status
    ) {
        this.id = id;
        this.vehicle = vehicle;
        this.user = user;
        this.bookingDate = bookingDate;
        this.fromTimeStamp = fromTimeStamp;
        this.toTimeStamp = toTimeStamp;
        this.status = status;
    }
}

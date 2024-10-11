package com.aditya.DesignPattern.lld.hotelManagementSystem;

public class HotelManagementService {

    private GuestService guestService;
    private RoomService roomService;
    private ReservationService reservationService;

    public HotelManagementService() {
        guestService = new GuestService();
        roomService = new RoomService();
        reservationService = new ReservationService();
    }


    public void addGuest(Guest guest) {
        guestService.addGuest(guest);
    }

    public Guest getGuest(String name) {
        return guestService.getGuest(name);
    }

    public void addRoom(Room room) {
        roomService.addRoom(room);
    }

    public Room getRoom(String roomId) {
        return roomService.getRoom(roomId);
    }

    public Room getAvailableRoomOfType(RoomType roomType) {
        return roomService.getAvailableRoomOfType(roomType);
    }

    public Reservation bookRoom(String roomId, String guestId, Long checkInDate, Long checkOutDate) {
        Room room = roomService.getRoom(roomId);

        if (!room.getRoomStatus().equals(RoomStatus.AVAILABLE)) {
            System.out.println("Room is not available anymore!");
            return null;
        }

        int duration = (int) (checkOutDate - checkInDate) / 1000;
        double price = duration * room.getPrice();

        Reservation reservation = reservationService.createReservation(
                guestId, roomId, checkInDate, checkOutDate, price);
        roomService.updateRoomStatus(roomId, RoomStatus.BOOKED);
        reservationService.updateReservationStatus(reservation.getId(), ReservationStatus.CONFIRMED);
        System.out.println("Room " + roomId + " for guest " + guestId + " has been booked");

        return reservation;
    }

    public void checkinGuest(String reservationId, String guestId) {
        Reservation reservation = reservationService.getReservation(reservationId);

        if (!reservation.getGuestId().equals(guestId) || reservation.getStatus().equals(ReservationStatus.CANCELLED)) {
            System.out.println("Following reservation is not valid " + guestId);
            return;
        }

        roomService.updateRoomStatus(reservation.getRoomId(), RoomStatus.OCCUPIED);
        System.out.println("Guest " + guestId + " CheckedIn for room" + reservation.getRoomId());
    }

    public void checkoutGuest(String reservationId, String guestId) {
        Reservation reservation = reservationService.getReservation(reservationId);

        if (!reservation.getGuestId().equals(guestId) || reservation.getStatus().equals(ReservationStatus.CANCELLED)) {
            System.out.println("Following reservation is not booked by guest " + guestId);
            return;
        }

        System.out.println("Please Pay :" + reservation.getPrice());

        roomService.updateRoomStatus(reservation.getRoomId(), RoomStatus.AVAILABLE);
        System.out.println("Guest " + guestId + " CheckedOut for room" + reservation.getRoomId());
    }

    public void cancelReservation(String reservationId, String guestId) {
        Reservation reservation = reservationService.getReservation(reservationId);

        if (!reservation.getGuestId().equals(guestId)) {
            System.out.println("Following reservation is not booked by guest " + guestId);
            return;
        }

        reservationService.updateReservationStatus(reservation.getId(), ReservationStatus.CANCELLED);
    }
}

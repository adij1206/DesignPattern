package com.aditya.DesignPattern.lld.hotelManagementSystem;

public class Demo {

    public static void main(String[] args) {
        Guest guest1 = new Guest("Aditya", "945989898");
        Guest guest2 = new Guest("Adi", "945989898");

        Room room1 = new Room("101", 100.0, RoomType.SINGLE);
        Room room2 = new Room("102", 120.0, RoomType.SINGLE);
        Room room3 = new Room("201", 200.0, RoomType.DOUBLE);
        Room room4 = new Room("202", 400.0, RoomType.DELUXE);

        HotelManagementService hotelManagementService = new HotelManagementService();
        hotelManagementService.addGuest(guest1);
        hotelManagementService.addGuest(guest2);

        hotelManagementService.addRoom(room1);
        hotelManagementService.addRoom(room2);
        hotelManagementService.addRoom(room3);
        hotelManagementService.addRoom(room4);

        System.out.println(hotelManagementService.getAvailableRoomOfType(RoomType.SINGLE));
        System.out.println(hotelManagementService.getAvailableRoomOfType(RoomType.DOUBLE));
        System.out.println(hotelManagementService.getAvailableRoomOfType(RoomType.DELUXE));

        Reservation reservation1 = hotelManagementService.bookRoom(
                room1.getRoomId(),
                guest1.getId(),
                System.currentTimeMillis(),
                System.currentTimeMillis() + 5000
        );

        Reservation reservation2 = hotelManagementService.bookRoom(
                room1.getRoomId(),
                guest2.getId(),
                System.currentTimeMillis(),
                System.currentTimeMillis() + 6000
        );

        if (reservation2 == null) {
            System.out.println("Not able tp reserve the room");
        }

        System.out.println(hotelManagementService.getAvailableRoomOfType(RoomType.SINGLE));

        Reservation reservation3 = hotelManagementService.bookRoom(
                room4.getRoomId(),
                guest2.getId(),
                System.currentTimeMillis() + 2000,
                System.currentTimeMillis() + 5000
        );

        hotelManagementService.checkinGuest(reservation1.getId(), guest1.getId());

        hotelManagementService.cancelReservation(reservation3.getId(), guest2.getId());
        hotelManagementService.checkinGuest(reservation3.getId(), guest2.getId());

        hotelManagementService.checkoutGuest(reservation1.getId(), guest1.getId());

        System.out.println(hotelManagementService.getAvailableRoomOfType(RoomType.SINGLE));
    }
}

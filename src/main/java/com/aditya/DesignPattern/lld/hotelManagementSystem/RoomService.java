package com.aditya.DesignPattern.lld.hotelManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class RoomService {

    private Map<String, Room> rooms;

    public RoomService() {
        this.rooms = new HashMap<>();
    }

    public void addRoom(Room room) {
        this.rooms.put(room.getRoomId(), room);
    }

    public Room getRoom(String roomId) {
        return this.rooms.get(roomId);
    }

    public Room getAvailableRoomOfType(RoomType roomType) {
        for (Room r : rooms.values()) {
            if (r.getRoomStatus().equals(RoomStatus.AVAILABLE) && r.getRoomType().equals(roomType)) {
                return r;
            }
        }

        return null;
    }

    public synchronized void updateRoomStatus(String roomId, RoomStatus roomStatus) {
        this.rooms.get(roomId).setRoomStatus(roomStatus);
    }
}

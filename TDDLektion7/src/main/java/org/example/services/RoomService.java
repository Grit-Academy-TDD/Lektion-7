package org.example.services;

import java.util.ArrayList;

public class RoomService {
    private ArrayList<String> availableRooms = new ArrayList<>();

    public ArrayList<String> getAvailableRooms() {
        fetchRoomsFromDB();
        return availableRooms;
    }

    public String getRoomByIndex(int index) {
        if (getAvailableRoomsCount() < index || index > getAvailableRoomsCount()) {
            throw new IllegalStateException();
        }
        return availableRooms.get(index);
    }

    public int getAvailableRoomsCount() {
        return availableRooms.size();
    }

    private void fetchRoomsFromDB() {
        //Vi antar att denna metod returnera lediga room från DB
    }
}

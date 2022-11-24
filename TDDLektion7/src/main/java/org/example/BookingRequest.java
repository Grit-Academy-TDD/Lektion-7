package org.example;

public class BookingRequest {
    private String userId;
    private int guestCount;
    private int daysStaying;
    private boolean prepaid;
    private String roomId;

    public BookingRequest(String userId, int guestCount, int daysStaying, boolean prepaid, String roomId) {
        this.userId = userId;
        this.guestCount = guestCount;
        this.daysStaying = daysStaying;
        this.prepaid = prepaid;
        this.roomId = roomId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    public int getDaysStaying() {
        return daysStaying;
    }

    public void setDaysStaying(int daysStaying) {
        this.daysStaying = daysStaying;
    }

    public boolean isPrepaid() {
        return prepaid;
    }

    public void setPrepaid(boolean prepaid) {
        this.prepaid = prepaid;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}

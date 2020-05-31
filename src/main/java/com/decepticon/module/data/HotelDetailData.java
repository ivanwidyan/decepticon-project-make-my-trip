package com.decepticon.module.data;

public class HotelDetailData {
    private static String roomName;

    public static String getRoomName() {
        return roomName;
    }

    public static void setRoomName(String roomName) {
        HotelDetailData.roomName = roomName;
    }
}

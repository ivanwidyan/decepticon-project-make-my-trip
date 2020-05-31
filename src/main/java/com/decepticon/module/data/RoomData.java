package com.decepticon.module.data;

public class RoomData {
    private static String hotelName;
    private static String totalAmount;
    private static String roomName;

    public static String getRoomName() {
        return roomName;
    }

    public static void setRoomName(String roomName) {
        RoomData.roomName = roomName;
    }

    public static String getHotelName() {
        return hotelName;
    }

    public static void setHotelName(String hotelName) {
        RoomData.hotelName = hotelName;
    }

    public static String getTotalAmount() {
        return totalAmount;
    }

    public static void setTotalAmount(String totalAmount) {
        RoomData.totalAmount = totalAmount;
    }

}

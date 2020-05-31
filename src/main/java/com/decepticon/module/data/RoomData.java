package com.decepticon.module.data;

public class RoomData {
    private static String hotelName;
    private static String totalAmount;
    private static String guest;
    private static String checkinDate;
    private static String checkoutDate;

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

    public static String getGuest() {
        return guest;
    }

    public static void setGuest(String guest) {
        RoomData.guest = guest;
    }

    public static String getCheckinDate() {
        return checkinDate;
    }

    public static void setCheckinDate(String checkinDate) {
        RoomData.checkinDate = checkinDate;
    }

    public static String getCheckoutDate() {
        return checkoutDate;
    }

    public static void setCheckoutDate(String checkoutDate) {
        RoomData.checkoutDate = checkoutDate;
    }
}

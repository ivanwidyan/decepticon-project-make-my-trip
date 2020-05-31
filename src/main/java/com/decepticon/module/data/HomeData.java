package com.decepticon.module.data;

public class HomeData {
    private static String country;
    private static String city;
    private static String username;
    private static String password;
    private static String dateCheckIn;
    private static String dateCheckOut;

    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        HomeData.country = country;
    }

    public static String getCity() {
        return city;
    }

    public static void setCity(String city) {
        HomeData.city = city;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        HomeData.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        HomeData.password = password;
    }

    public static String getDateCheckIn() {
        return dateCheckIn;
    }

    public static void setDateCheckIn(String dateCheckIn) {
        HomeData.dateCheckIn = dateCheckIn;
    }

    public static String getDateCheckOut() {
        return dateCheckOut;
    }

    public static void setDateCheckOut(String dateCheckOut) {
        HomeData.dateCheckOut = dateCheckOut;
    }

    public static String getTravellingFor() {
        return travellingFor;
    }

    public static void setTravellingFor(String travellingFor) {
        HomeData.travellingFor = travellingFor;
    }

    public static String travellingFor;
}

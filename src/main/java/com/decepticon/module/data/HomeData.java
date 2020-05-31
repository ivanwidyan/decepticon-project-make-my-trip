package com.decepticon.module.data;

import lombok.Data;

@Data
public class HomeData {
    private String country;
    private String city;
    private String username;
    private String password;
    private String dateCheckIn;
    private String dateCheckOut;
    private String travellingFor;
}

package com.decepticon.runner.test;

import com.decepticon.module.ui.HomePage;
import com.decepticon.module.ui.HotelDetailPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class HotelDetailRunner {

    // chrome, firefox, appium, remote
    @Managed
    WebDriver driver;

    HomePage googlePage;

    HotelDetailPage hotelDetailPage;

    @Test
    public void openpage() {
      hotelDetailPage.openPage();
        hotelDetailPage.getRoomName(2);

    }

//    @Test
//    public void getroomname() {
//
//
//
//
//    }


}
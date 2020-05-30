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
    WebDriver webDriver;

    HotelDetailPage hotelDetailPage;

    @Test
    public void openpage() {
//        hotelDetailPage.openPage();
        hotelDetailPage.openPage();
        hotelDetailPage.getRoomName(1);
        hotelDetailPage.getRoomDetail(1);
        hotelDetailPage.getPrice(1, 1);
        hotelDetailPage.getOption(1, 1);
        hotelDetailPage.getIncludeList(1, 1);
        hotelDetailPage.selectRoom(1, 1);

    }


}
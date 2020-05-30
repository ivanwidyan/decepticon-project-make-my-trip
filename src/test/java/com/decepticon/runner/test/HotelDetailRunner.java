package com.decepticon.runner.test;

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
        hotelDetailPage.getTextRoomName(1);
        hotelDetailPage.getListRoomDetail(1);
        hotelDetailPage.getTextPrice(1, 1);
        hotelDetailPage.getListOption(1, 1);
        hotelDetailPage.getListIncluded(1, 1);
        hotelDetailPage.clickButtonSelectRoom(1, 1);

    }

    @Test
    public void openpageMultiple() {
//        hotelDetailPage.openPage();
        hotelDetailPage.openPageMultiple();
        hotelDetailPage.getTextRoomName(1);
        hotelDetailPage.getListRoomDetail(1);
        hotelDetailPage.getTextPriceForMultiple(1, 1);
        hotelDetailPage.getListMultiOption(1, 1);
        hotelDetailPage.getListIncludedMultiOption(1, 1);
        hotelDetailPage.clickButtonPeopleCount(1, 2);
        hotelDetailPage.clickButtonSelectPeopleCountList( 2);
        hotelDetailPage.clickButtonAddRoom(1, 1);
        hotelDetailPage.getTextTotalPriceForMultiple();
        hotelDetailPage.clickButtonAddRoom(1, 1);
        hotelDetailPage.getTextTotalPriceForMultiple();
        hotelDetailPage.clickButtonAddRoom(1, 1);
        hotelDetailPage.getTextTotalPriceForMultiple();
        hotelDetailPage.clickButtonAddRoom(1, 1);
        hotelDetailPage.getTextTotalPriceForMultiple();
        hotelDetailPage.clickButtonReviewDetail();
//        hotelDetailPage.clickButtonSelectRoom(1, 1);

    }


}
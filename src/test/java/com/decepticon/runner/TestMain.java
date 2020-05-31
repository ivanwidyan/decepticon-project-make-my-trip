package com.decepticon.runner;

import com.decepticon.module.ui.HomePage;
import com.decepticon.module.ui.HotelDetailPage;
import com.decepticon.module.ui.SearchPage;
import com.decepticon.module.utils.Utility;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class TestMain {

    // chrome, firefox, appium, remote
    @Managed
    WebDriver driver;

    HomePage homePage;

    SearchPage searchPage;

    HotelDetailPage hotelDetailPage;

    @Test
    public void testCustomDriver() throws Exception {
        // Home page
        homePage.openPage();
        homePage.clickButtonHotel();
//        homePage.clickButtonLogin();
//        homePage.typeTextBoxEmail("test");
//        homePage.clickButtonSubmit();
        homePage.clickButtonCity();
        homePage.typeTextBoxCity("Indonesia");
        homePage.clickListButtonCity("Bali");

        checkTheDate("June", "17");
        homePage.clickButtonDate("June", "17");

        checkTheDate("June", "20");
        homePage.clickButtonDate("June", "20");
        homePage.clickButtonRoom();
        int t = 0;
        while(t < 1) {
            homePage.clickButtonNumberOfAdults("2");
            homePage.clickButtonNumberOfChildren("2");
            homePage.clickButtonAddRooms();
            t++;
        }
        homePage.clickButtonApplyRoom();
        homePage.clickButtonTravelFor();
        homePage.clickListButtonTravelFor("Work");
        homePage.clickButtonSearch();

//        searchPage.openPage();
        searchPage.clickButtonFilterByUserRatings("4 & above (Very Good)");
        searchPage.dragSliderFilterMinPrice("1000");
//        searchPage.assertion("1000","4 & above (Very Good)");
        searchPage.clickButtonHotelName(5);

//        hotelDetailPage.openPage();
        hotelDetailPage.getTextRoomName("1");
        hotelDetailPage.getListRoomDetail("1");
        hotelDetailPage.getTextPrice("1", "1");
        hotelDetailPage.getListOption("1", "1");
        hotelDetailPage.getListIncluded("1", "1");
        hotelDetailPage.clickButtonSelectRoom("1", "1");

        Utility.delayInSeconds(10);
    }

    public void checkTheDate(String month, String date){
        while (!homePage.isDateMatch(month, date)) {
            homePage.clickButtonNextDate();
        }
    }
}
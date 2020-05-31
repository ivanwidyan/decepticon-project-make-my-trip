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
        homePage.clickMenuHotel();
//        homePage.clickButtonLogin();
//        homePage.typeTextBoxEmail("test");
//        homePage.clickButtonSubmit();
        homePage.clickSectionCity();
        homePage.typeTextBoxCity("Indonesia");
        homePage.clickListCity("Bali");

        checkTheDate("June", "17");
        homePage.clickDate("June", "17");

        checkTheDate("June", "20");
        homePage.clickDate("June", "20");
        homePage.clickSectionRoom();
        int t = 0;
        while(t < 1) {
            homePage.clickNumberOfAdults("2");
            homePage.clickNumberOfChildren("2");
            homePage.clickButtonAddRooms();
            t++;
        }
        homePage.clickButtonApplyRoom();
        homePage.clickSectionTravelFor();
        homePage.clickSelectTravelFor("Work");
        homePage.clickButtonSearch();

//        searchPage.openPage();
        searchPage.filterByUserRating("4 & above (Very Good)");
        searchPage.filterByPrice("1000");
//        searchPage.assertion("1000","4 & above (Very Good)");
        searchPage.newSelectHotel(5);

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
        while (!homePage.isDateIsMatch(month, date)) {
            homePage.clickButtonNextDate();
        }
    }
}
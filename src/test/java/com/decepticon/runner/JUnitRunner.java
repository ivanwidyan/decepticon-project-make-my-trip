package com.decepticon.runner;

import com.decepticon.module.constant.Consts;
import com.decepticon.module.data.HomeData;
import com.decepticon.module.ui.*;
import com.decepticon.module.utils.CommonAction;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@RunWith(SerenityRunner.class)
public class JUnitRunner {

    // chrome, firefox, appium, remote
    @Managed
    WebDriver driver;

    HomePage homePage;

    SearchPage searchPage;

    HotelDetailPage hotelDetailPage;

    RoomPage roomPage;

    BookingSummaryPage bookingSummaryPage;

    CommonAction commonAction;

    private final String userRating = "4 & above (Very Good)";
    private final String price = "1000";

    @Test
    public void testCustomDriver() throws Exception {
        // Home page flow
        homePage.openPage();
        homePage.clickButtonLogin();
        homePage.typeTextBoxEmail("Satutesting2@gmail.com");
        homePage.clickButtonSubmitForUsername();
        homePage.typeTextBoxPassword("mytripbolot1!");
        homePage.clickButtonSubmitForPassword();
        homePage.clickButtonClose();

        homePage.clickButtonHotel();
        homePage.clickButtonCity();
        homePage.typeTextBoxCity("Indonesia");
        HomeData.setCountry("Indonesia");
        homePage.clickListButtonCity("Bali");
        HomeData.setCity("Bali");
        checkTheDate("June", "17");
        HomeData.setDateCheckIn(homePage.getTextDate("June", "17"));
        homePage.clickButtonDate("June", "17");
        checkTheDate("June", "20");
        HomeData.setDateCheckOut(homePage.getTextDate("June", "20"));
        homePage.clickButtonDate("June", "20");
        homePage.clickButtonRoom();
        int t = 0;
        while (t < 1) {
            homePage.clickButtonNumberOfAdults("2");
            homePage.clickButtonNumberOfChildren("2");
            loopClickAgeChildren("2,3");
            homePage.clickButtonAddRooms();
            homePage.clickButtonNumberOfAdults("2");
            homePage.clickButtonNumberOfChildren("2");
            loopClickAgeChildren("2,3");
            t++;
        }
        homePage.clickButtonApplyRoom();
        homePage.clickButtonTravelFor();
        homePage.clickListButtonTravelFor("Work");
        homePage.clickButtonSearch();

        // Search Page Flow
        commonAction.refreshPage();
        searchPage.clickButtonCurrency("INR - Indian Rupee");
        searchPage.clickButtonFilterByUserRatings(userRating);
        searchPage.dragSliderFilterMinPrice(price);

        List<String> appliedFilters = searchPage.getListTextFilter();
        System.out.println(appliedFilters);
        assertThat("min price filter is wrong",
                appliedFilters.contains("INR " + price + "-30000"), equalTo(true));

        assertThat("user rating filter is wrong",
                appliedFilters.contains(userRating), equalTo(true));

        searchPage.clickButtonHotelName(5);
        commonAction.switchTab(Consts.SECOND_INDEX);

        //Hotel Detail Flow
        hotelDetailPage.getTextRoomName("1");
        hotelDetailPage.getListRoomDetail("1");
        hotelDetailPage.getTextPrice("1", "1");
        hotelDetailPage.getListOption("1", "1");
        hotelDetailPage.getListIncluded("1", "1");
        hotelDetailPage.clickButtonSelectRoom("1", "1");

        // Room Page Flow
        roomPage.typeTextBoxFirstName("We are");
        roomPage.typeTextBoxLastName("Deception");
        roomPage.typeTextBoxEmail("Deception@mailinator.com");
        roomPage.selectMobileCode("+62");
        roomPage.typeTextBoxMobileNumber("81234567890");
        if(roomPage.isPopupLeavingPageVisible())
            roomPage.clickButtonClose();
        if(roomPage.isTextBoxPanVisible())
            roomPage.typeTextBoxPanString("101");
        roomPage.clickCheckListOptions("Large bed");
        roomPage.clickCheckListOptions("Smoking room");
        roomPage.clickCheckBoxDonation();
        roomPage.clickButtonPayNow();

        // Booking Summary Flow
        System.out.println(bookingSummaryPage.getTextHotelName());
        System.out.println(bookingSummaryPage.getTextAdress());
        System.out.println(bookingSummaryPage.getTextCheckInDate());
        System.out.println(bookingSummaryPage.getTextCheckOutDate());
        System.out.println(bookingSummaryPage.getTextRoomName());
        System.out.println(bookingSummaryPage.getNumberGuestsAmounts());
        System.out.println(bookingSummaryPage.getTextTotalAmount());

        assertThat("text hotel name is wrong",
                bookingSummaryPage.getTextHotelName(), equalTo("Grand Zuri Kuta Bali"));
        assertThat("text check in date is wrong",
                bookingSummaryPage.getTextCheckInDate(), equalToIgnoringCase("Wed 17 Jun 2020"));
        assertThat("text check out date is wrong",
                bookingSummaryPage.getTextCheckOutDate(), equalToIgnoringCase("Sat 20 Jun 2020"));
        assertThat("text room name is wrong",
                bookingSummaryPage.getTextRoomName(), equalToIgnoringCase("Superior Room"));
        assertThat("number adult is wrong",
                bookingSummaryPage.getNumberGuestsAmounts().get("adult"), equalTo(4));
        assertThat("number children is wrong",
                bookingSummaryPage.getNumberGuestsAmounts().get("child"), equalTo(4));
        assertThat("text total amount is wrong",
                bookingSummaryPage.getTextTotalAmount(), equalTo("7,072"));
    }

    public void checkTheDate(String month, String date){
        while (!homePage.isDateMatch(month, date)) {
            homePage.clickButtonNextDate();
        }
    }

    public void loopClickAgeChildren(String ages) {
        String[] age = ages.split(",");
        for (int x = 0; x < age.length; x++) {
            homePage.clickButtonAgeChildren(String.valueOf(x));
            homePage.clickListButtonAgeChildren(String.valueOf(x), String.valueOf(age[x]));
        }
    }
}
package com.decepticon.runner.test;

import com.decepticon.module.constant.Consts;
import com.decepticon.module.ui.BookingSummaryPage;
import com.decepticon.module.utils.Utility;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@RunWith(SerenityRunner.class)
public class BookingSummaryRunner {

    // chrome, firefox, appium, remote
    @Managed
    WebDriver driver;

    BookingSummaryPage bookingSummaryPage;

    @Test
    public void BookingSummaryPageTest() {
        /** Home page
         * Wed Jun 17 2020
         * Sat Jun 20 2020
         * Guest
         * Rooms
         */

        bookingSummaryPage.openPage();
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
                bookingSummaryPage.getTextTotalAmount(), equalTo("8,404"));
    }
}
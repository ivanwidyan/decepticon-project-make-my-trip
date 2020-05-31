package com.decepticon.runner.test;

import com.decepticon.module.ui.BookingSummaryPage;
import com.decepticon.module.ui.SearchPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class BookingSummaryRunner {

    // chrome, firefox, appium, remote
    @Managed
    WebDriver driver;

    BookingSummaryPage bookingSummaryPage;

    @Test
    public void testUI() {
        bookingSummaryPage.openPage();
        System.out.println(bookingSummaryPage.getNumberActiveStars());
        System.out.println(bookingSummaryPage.getTextAdress());
        System.out.println(bookingSummaryPage.getTextCheckInDate());
        System.out.println(bookingSummaryPage.getTextCheckInMonthDay());
        System.out.println(bookingSummaryPage.getTextCheckOutDate());
        System.out.println(bookingSummaryPage.getTextCheckOutMonthDay());
        System.out.println(bookingSummaryPage.getTextCityName());
        System.out.println(bookingSummaryPage.getTextTotalAmount());

    }
}
package com.decepticon.runner.test;

import com.decepticon.module.data.HomeData;
import com.decepticon.module.ui.HomePage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@UseTestDataFrom(value = "src/test/resources/makemytrip.csv")
public class HomeRunner {

    // chrome, firefox, appium, remote
    @Managed
    WebDriver driver;

    HomePage homePage;

    HomeData homeData;


    @Test
    public void userDoLogin() {
        homePage.openPage();
        homePage.clickButtonLogin();
        homePage.typeTextBoxEmail("Satutesting2@gmail.com");
        homePage.clickButtonSubmit();
        homePage.clickButtonSubmit();
        homePage.typeTextBoxPassword("mytripbolot1!");
        homePage.clickButtonSubmit();
        homePage.clickButtonClose();
    }


    @Test
    public void userDoSearchHotel() {

        homePage.openPage();
        homePage.clickMenuHotel();
        homePage.clickSectionCity();
        homePage.typeTextBoxCity("Indonesia");
        homePage.clickListCity("Bali");
        checkTheDate("June", "17");
        homePage.clickDate("June", "17");
        checkTheDate("June", "20");
        homePage.clickDate("June", "20");
        homePage.clickSectionRoom();
        int t = 0;
        while (t < 1) {
            homePage.clickNumberOfAdults("2");
            homePage.clickNumberOfChildren("2");
            loopClickAgeChildren("2,3");
            homePage.clickButtonAddRooms();
            homePage.clickNumberOfAdults("2");
            homePage.clickNumberOfChildren("2");
            loopClickAgeChildren("2,3");
            t++;
        }
        homePage.clickButtonApplyRoom();
        homePage.clickSectionTravelFor();
        homePage.clickSelectTravelFor("Work");
        homePage.clickButtonSearch();
    }

    public void checkTheDate(String month, String date) {
        while (!homePage.isDateIsMatch(month, date)) {
            homePage.clickButtonNextDate();
        }
    }

    public void loopClickAgeChildren(String ages) {
        String[] age = ages.split(",");
        for (int x = 0; x < age.length; x++) {
            homePage.clickbuttonAgeChildren(String.valueOf(x));
            homePage.clickListButtonAgeChildren(String.valueOf(x), String.valueOf(age[x]));
        }
    }
}
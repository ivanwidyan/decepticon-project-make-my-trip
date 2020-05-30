package com.decepticon.runner.test;

import com.decepticon.module.data.HomeData;
import com.decepticon.module.ui.HomePage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class HomeRunner {

    // chrome, firefox, appium, remote
    @Managed
    WebDriver driver;

    HomePage homePage;

    HomeData homeData;



    @Test
    public void userDoLogin() {

        homePage.openPage();
        homePage.clickMenuHotel();
//        homePage.clickButtonLogin();
//        homePage.typeTextBoxEmail("test");
//        homePage.clickButtonSubmit();
        homePage.clickSectionCity();
        homePage.typeTextBoxCity("Indonesia");
        homePage.clickListCity("Bali");
        checkTheDate();
        homePage.clickDate("August", "17");
        homePage.clickSectionRoom();
        int t = 0;
        while(t < 1 ){
            homePage.clickNumberOfAdults("2");
            homePage.clickNumberOfChildren("2");
            homePage.clickButtonAddRooms();
            t++;
        }
        homePage.clickButtonApplyRoom();
    }

    public void checkTheDate(){
        while (!homePage.isDateIsMatch("August", "17")) {
            homePage.clickButtonNextDate();
        }
    }
}
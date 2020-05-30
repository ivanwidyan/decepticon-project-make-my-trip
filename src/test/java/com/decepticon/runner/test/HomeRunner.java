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


    }

    public void checkTheDate(){
        while (!homePage.isDateIsMatch("August", "17")) {
            homePage.clickButtonNextDate();
        }
        homePage.clickDate("August", "17");
    }
}
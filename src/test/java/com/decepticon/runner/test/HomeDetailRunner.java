package com.decepticon.runner.test;

import com.decepticon.module.ui.HomePage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class HomeDetailRunner {

    // chrome, firefox, appium, remote
    @Managed(driver = "chrome")
    WebDriver driver;

    HomePage homePage;

    @Test
    public void testUI() {

        homePage.openPage();
        homePage.doLogin();
        homePage.doSearch();
    }
}
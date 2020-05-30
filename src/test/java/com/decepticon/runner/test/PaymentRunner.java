package com.decepticon.runner.test;

import com.decepticon.module.ui.HomePage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class PaymentRunner {

    // chrome, firefox, appium, remote
    @Managed(driver = "chrome")
    WebDriver driver;

    HomePage googlePage;

    @Test
    public void testUI() {
        googlePage.openPage();
    }
}
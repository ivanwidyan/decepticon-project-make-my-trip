package com.decepticon.runner;

import com.decepticon.module.ui.HomePage;
import com.decepticon.module.utils.ReportHandler;
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

    @Test
    public void testCustomDriver() throws Exception {
        homePage.openPage();
        Thread.sleep(10000);
    }

    @Test
    public void check() {
        homePage.openPage();
    }

    @Test
    public void report() {
        ReportHandler.generateDummyReport();
    }

    @Test
    public void testIvan() {
        System.out.println(Utility.getProperty("customdriver.browserName"));
    }
}
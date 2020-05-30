package com.decepticon.runner.test;

import com.decepticon.module.api.ApiController;
import com.decepticon.module.ui.HomePage;
import com.decepticon.module.utils.Handler;
import com.decepticon.module.utils.ReportHandler;
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

    HomePage googlePage;

    @Test
    public void testUI() {
        googlePage.openPage();
    }
}
package com.decepticon.runner.test;

import com.decepticon.module.ui.RoomPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class RoomRunner {

    // chrome, firefox, appium, remote
    @Managed
    WebDriver driver;

    RoomPage roomPage;

    @Test
    public void testUI() {

        roomPage.openPage();
        roomPage.typeTextBoxFirstName("We are");
        roomPage.typeTextBoxLastName("Deception");
        roomPage.typeTextBoxEmail("Deception@mailinator.com");
        roomPage.clickButtonMobileCode();
        roomPage.clickListButtonMobileCode("+62");
        roomPage.typeTextBoxMobileNumber("81234567890");
        roomPage.typeTextBoxPanString("101");
        roomPage.clickCheckListOptions("Large bed");
        roomPage.clickCheckListOptions("Smoking room");
        roomPage.clickCheckBoxDonation();
        roomPage.clickButtonPayNow();
    }
}
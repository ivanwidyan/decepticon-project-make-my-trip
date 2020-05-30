package com.decepticon.module.utils;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CommonAction extends UiUtility {

    // Open URL
    public void openPage(String url) {
        openAt(url);
    }

    public void switchToOpenedTab(WebDriver driver) {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
    }

    public void switchToMainTab(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    // Verify Page is Opened
    public Boolean verifyPageIsOpened(String url) {
        return verifyUrlIsOpened(url);
    }
}

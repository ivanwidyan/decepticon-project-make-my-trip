package com.decepticon.module.utils;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class CommonAction extends UiUtility {

    // Open URL
    public void openPage(String url) {
        openAt(url);
    }

    public void switchTab(Integer tabIndex) {
        ArrayList<String> tabs2 = new ArrayList<> (getDriver().getWindowHandles());
//        driver.switchTo().window(tabs2.get(1));
//        driver.close();
        getDriver().switchTo().window(tabs2.get(tabIndex));

//        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
    }

    public void switchToMainTab(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    // Verify Page is Opened
    public Boolean verifyPageIsOpened(String url) {
        return verifyUrlIsOpened(url);
    }
}

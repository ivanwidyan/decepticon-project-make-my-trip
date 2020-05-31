package com.decepticon.module.utils;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class CommonAction extends UiUtility {

    public void openPage(String url) {
        openAt(url);
    }

    public void switchTab(Integer tabIndex) {
        ArrayList<String> tabs2 = new ArrayList<> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(tabIndex));
    }

    public void switchToMainTab(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public Boolean verifyPageIsOpened(String url) {
        return verifyUrlIsOpened(url);
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }
}

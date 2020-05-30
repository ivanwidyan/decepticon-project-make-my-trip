package com.decepticon.module.utils;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class UiUtility extends PageObject {

    public WebElementFacade fromXpathtoWebElement(String xpath, String value){
        return find(By.xpath(String.format(xpath, value)));
    }
}

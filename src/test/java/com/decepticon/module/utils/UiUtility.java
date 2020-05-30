package com.decepticon.module.utils;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class UiUtility extends PageObject {

    public WebElementFacade fromXpathtoWebElement(String xpath, String value){
        return find(By.xpath(String.format(xpath, value)));
    }
    public WebElementFacade fromXpathtoWebElementString(String xpath){
        return find(By.xpath(String.format(xpath)));
    }

    public List<WebElementFacade> xpathToWebElement(String xpath) {
        List<WebElementFacade> webElementFacades = findAll(new By.ByXPath(xpath));

        return webElementFacades;
    }
}

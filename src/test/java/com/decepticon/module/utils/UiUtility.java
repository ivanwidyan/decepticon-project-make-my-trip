package com.decepticon.module.utils;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class UiUtility extends PageObject {

    protected List<String> listWebElementsToListString(List<WebElementFacade> listWebElements) {
        List<String> stringList = new ArrayList<>();
        for (WebElementFacade w : listWebElements) {
            stringList.add(w.getText());
        }
        return stringList;

    }

    protected WebElementFacade fromXpathtoWebElement(String xpath){
        return find(By.xpath(xpath));
    }

    protected WebElementFacade fromXpathtoWebElementString(String xpath){
        return find(By.xpath(String.format(xpath)));
    }

    protected List<WebElementFacade> xpathToWebElement(String xpath) {
        List<WebElementFacade> webElementFacades = findAll(new By.ByXPath(xpath));

        return webElementFacades;
    }

    protected Boolean verifyUrlIsOpened(String url) {
        System.out.println("currentUrl: " + getDriver().getCurrentUrl());
        System.out.println("expected: " + url);
        return getDriver().getCurrentUrl().contains(url);
    }
}

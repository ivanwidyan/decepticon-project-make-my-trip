package com.decepticon.module.utils;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class UiUtility extends PageObject {

    protected List<String> listWebElementsToListString(List<WebElementFacade> listWebElements) {
        List<String> stringList = new ArrayList<>();
        for (WebElementFacade w : listWebElements) {
            stringList.add(w.getText());
            System.out.println(w.getText());
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

    protected void selectOptionByWebElement(WebElementFacade webElementFacade, String value){
        Select select = new Select(webElementFacade);
        select.selectByValue(value);
    }

    protected void clickByWebElement(WebElementFacade webElementFacade){
        webElementFacade.waitUntilPresent();
        JSExecutorUtility.clickByWebElement(webElementFacade, getDriver());
    }

    protected void clickByWebElementWithNotFoundHandling(WebElementFacade webElementFacade){
        try {
//            webElementFacade.waitUntilPresent();
            JSExecutorUtility.clickByWebElement(webElementFacade, getDriver());
            webElementFacade.click();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected String getTextByWebElementWithNotFoundHandling(WebElementFacade webElementFacade) {
        webElementFacade.waitUntilPresent();
        try {
            return webElementFacade.getText();
        } catch (Exception e) {
            return null;
        }
    }
}

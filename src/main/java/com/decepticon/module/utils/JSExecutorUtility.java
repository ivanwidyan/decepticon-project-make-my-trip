package com.decepticon.module.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExecutorUtility {

    public static void setValuesById(String id, String values, WebDriver webDriver){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript(String.format("document.getElementById('%s').value='%s';", id, values));
    }

    public static void clickById(String id, WebDriver webDriver){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript(String.format("document.getElementById('%s').click()", id));
    }

    public static void clickByDocument(String document, WebDriver webDriver){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript(String.format("%s.click()", document));
    }

    public static void clickByWebElement(WebElement element, WebDriver webDriver){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void getTextByElement(WebElement element, WebDriver webDriver){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].getText();", element);
    }

    public static void clickByWebElement(String id, Boolean checked, WebDriver webDriver){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript(String.format("document.getElementById('%s').checked=%s;", id, checked));
    }

    public static void jumpIntoElement(WebElement element, WebDriver webDriver){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

}
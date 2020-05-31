package com.decepticon.module.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public static void scrollToTheEndOfThePage(WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
}
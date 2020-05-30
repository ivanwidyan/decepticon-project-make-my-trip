package com.decepticon.module.utils;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Utility {

    public  WebDriverWait driverWait(WebDriver driver) {

        return new WebDriverWait(driver, 20);
    }
    private static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    public static String getConfig(String key) {
        return EnvironmentSpecificConfiguration.from(variables).getProperty(key);
    }
    public void scrollToElement(WebDriver driver, WebElement element)
    {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    public void waitForElementVisiblity(WebDriver driver, WebElement element){
        WebDriverWait driverWait = new WebDriverWait(driver, 20);
        driverWait.until(ExpectedConditions
                .visibilityOf(element));
    }
    public void waitTillPageLoads(WebDriver driver) {
        driverWait(driver).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
    public void scrollToTheEndOfThePage(WebDriver driver)
    {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static String getProperty(String key) {
        return variables.getProperty(key);
    }

    public static void takeScreenshot(WebDriver webDriver){
        takeScreenshot(webDriver, "", String.valueOf(System.currentTimeMillis()));
    }

    public static void takeScreenshot(WebDriver webDriver, String path, String fileName){
        if (webDriver != null) {
            try {
                File file = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(file, new File(
                        "target/decepticon/report/data/ss/" + path +
                                fileName + ".png"));
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public static void saveImage(URL imageURL, String fileName) {
        saveImage(imageURL, "", fileName);
    }

    public static void saveImage(URL imageURL, String path, String fileName) {
        try {
            BufferedImage saveImage = ImageIO.read(imageURL);
            ImageIO.write(saveImage, "png", new File(
                    "target/decepticon/report/data/img/" + path +
                    fileName + ".png"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Boolean isMobileDriver() {
        return Utility.getProperty("webdriver.driver").equals("appium");
    }

    public static File createFile (String path) {
        File file = new File(path);
        return file;
    }

    public static void writeToFile (String data, String path) {
        File file = new File(path);
        try {
            FileUtils.writeStringToFile(file, data, "UTF-8");
        } catch (Exception e) {
            System.out.println("writeFile:" + e);
        }
    }

    public static void writeToFile (String data, File file) {
        try {
            FileUtils.writeStringToFile(file, data, "UTF-8");
        } catch (Exception e) {
            System.out.println("writeFile:" + e);
        }
    }

    public static void writeToFile (HashMap<String, String> hashMap, String path) {
        String data = "";
        for (String key : hashMap.keySet()) {
            data += key + "=" + hashMap.get(key) + "\n";
//            System.out.println("test:" + key + "=" + hashMap.get(key));
        }

        File file = new File(path);
        try {
            FileUtils.writeStringToFile(file, data, "UTF-8");
        } catch (Exception e) {
            System.out.println("writeFile:" + e);
        }
    }

    public static List<String> readFromFile (String path) {
        return readFromFile(path, false);
    }

    public static List<String> readFromFile (String path, Boolean lowercase) {
        List<String> list = new ArrayList<>();
        File file = new File(path);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null) {
                if (lowercase) {
                    list.add(st.toLowerCase());
                } else {
                    list.add(st);
                }
            }
        } catch (Exception e) {
            System.out.println("readFile:" + e);
        }
        return list;
    }

    public static String objToJsonString (Object obj) {
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = "{}";
        try {
            jsonStr = Obj.writeValueAsString(obj);
        }
        catch (IOException e) {
            System.out.println("parseObjectToJson:" + e);
        }
        return jsonStr;
    }

    public static String removeWhitespace(String s) {
        return s.replaceAll("\\s","");
    }

    public static void printHashMap (HashMap<String, String> hashMap) {
        for (String key : hashMap.keySet()) {
            System.out.println(key + "=" + hashMap.get(key));
        }
    }

    public static List<String> stringToList (String input) {
        String[] array = input.split(";");
        List<String> list = Arrays.asList(array);
        return list;
    }

    public static void delayInSeconds(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {

        }

    }
}

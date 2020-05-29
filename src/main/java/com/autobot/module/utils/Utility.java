package com.autobot.module.utils;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.TypeKey;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Utility {

    private static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    public static String getConfig(String key) {
        return EnvironmentSpecificConfiguration.from(variables).getProperty(key);
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
                        "target/autobot/report/data/ss/" + path +
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
                    "target/autobot/report/data/img/" + path +
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
}

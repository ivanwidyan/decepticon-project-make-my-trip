package com.decepticon.driver;

import com.decepticon.module.utils.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;

public class CustomRemoteDriver implements DriverSource {

    @Override
    public WebDriver newDriver() {
        RemoteWebDriver driver = null;

//        driver = createDriver("MicrosoftEdge", null);

//        driver = createDriver("firefox", null);

        // Chrome 76.0.3809.100
//        driver = createDriver("chrome", "76.0.3809.100");

        // Chrome 78.0.3904.108
//        driver = createDriver("chrome", "78.0.3904.108");

        // Chrome 79.0.3945.88
//        driver = createDriver("chrome", "79.0.3945.88");
        return driver;
    }

    private RemoteWebDriver createDriver(String browserName, String browserVersion) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Integer> screenSize = new HashMap<>();
        screenSize.put("width", 1920);
        screenSize.put("height", 1080);
        capabilities.setCapability("headspin:initialScreenSize", screenSize);
//        capabilities.setCapability("headspin:capture", true);
        capabilities.setCapability("browserName", browserName);
        if (browserVersion != null)
            capabilities.setCapability("browserVersion", browserVersion);
        System.out.println(capabilities);

        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    URI.create("https://dev-us-pao-0.headspin.io:9093/v0/bd1c05833b664a01b1a7abe02a2edf55/wd/hub").toURL(),
                    capabilities);
            System.out.println("driver is created");
        } catch (Exception e) {
            System.out.println(e);
        }

        return driver;
    }

    @Override
    public boolean takesScreenshots() {
        return false;
    }
}

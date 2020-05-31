package com.decepticon.driver;

import com.decepticon.module.constant.PropertiesConsts;
import com.decepticon.module.constant.ValueConsts;
import com.decepticon.module.utils.Utility;
import cucumber.api.java.an.E;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CustomDriver implements DriverSource {

    @Override
    public WebDriver newDriver() {

        String customDriverBrowserName = Utility.getProperty(PropertiesConsts.CUSTOM_DRIVER_BROWSER_NAME);

        if (ValueConsts.BROWSER_NAME_CHROME.equalsIgnoreCase(customDriverBrowserName)) {
            WebDriverManager.chromedriver().setup();
            System.out.println("chrome driver is started");
            return new ChromeDriver();
        } else if (ValueConsts.BROWSER_NAME_FIREFOX.equalsIgnoreCase(customDriverBrowserName)) {
            WebDriverManager.firefoxdriver().setup();
            System.out.println("firefox driver is started");
            return new FirefoxDriver();
        } else if (ValueConsts.BROWSER_NAME_EDGE.equalsIgnoreCase(customDriverBrowserName)) {
            WebDriverManager.edgedriver().setup();
            System.out.println("edge driver is started");
            return new EdgeDriver();
        } else {
            throw new UnsupportedOperationException("browser name is not supported");
        }
    }
    @Override
    public boolean takesScreenshots() {
        return false;
    }
}

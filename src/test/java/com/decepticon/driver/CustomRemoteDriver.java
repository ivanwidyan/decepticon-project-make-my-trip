package com.decepticon.driver;

import com.decepticon.module.constant.CapabilitiesConsts;
import com.decepticon.module.constant.ParamConsts;
import com.decepticon.module.constant.PropertiesConsts;
import com.decepticon.module.utils.Utility;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.util.HashMap;

public class CustomRemoteDriver implements DriverSource {

    @Override
    public WebDriver newDriver() {
        RemoteWebDriver driver;

        // firefox, MicrosoftEdge
        // chrome: 76.0.3809.100, 78.0.3904.108, 79.0.3945.88

        System.out.println(Utility.getProperty(PropertiesConsts.CUSTOM_DRIVER_BROWSER_NAME));
        System.out.println(Utility.getProperty(PropertiesConsts.CUSTOM_DRIVER_BROWSER_VERSION));
        System.out.println(Utility.getProperty(PropertiesConsts.CUSTOM_DRIVER_WIDTH));
        System.out.println(Utility.getProperty(PropertiesConsts.CUSTOM_DRIVER_HEIGHT));
        System.out.println(Utility.getProperty(PropertiesConsts.CUSTOM_DRIVER_REMOTEURL));

        driver = createDriver(Utility.getProperty(PropertiesConsts.CUSTOM_DRIVER_BROWSER_NAME),
                Utility.getProperty(PropertiesConsts.CUSTOM_DRIVER_BROWSER_VERSION));
        return driver;
    }

    private RemoteWebDriver createDriver(String browserName, String browserVersion) {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        Integer width = Integer.valueOf(Utility.getProperty(PropertiesConsts.CUSTOM_DRIVER_WIDTH));
        Integer height = Integer.valueOf(Utility.getProperty(PropertiesConsts.CUSTOM_DRIVER_HEIGHT));

        HashMap<String, Integer> screenSize = new HashMap<>();
        screenSize.put(ParamConsts.WIDTH, width);
        screenSize.put(ParamConsts.HEIGHT, height);
        capabilities.setCapability(CapabilitiesConsts.HEADSPIN_INITIAL_SCREEN_SIZE, screenSize);
        capabilities.setCapability(CapabilitiesConsts.BROWSER_NAME, browserName);
        if (browserVersion != null)
            capabilities.setCapability(CapabilitiesConsts.BROWSER_VERSION, browserVersion);
        System.out.println(capabilities);

        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    URI.create(Utility.getProperty(PropertiesConsts.CUSTOM_DRIVER_REMOTEURL)).toURL(),
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

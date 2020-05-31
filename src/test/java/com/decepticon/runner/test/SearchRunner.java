package com.decepticon.runner.test;

import com.decepticon.module.ui.HomePage;
import com.decepticon.module.ui.SearchPage;
import com.decepticon.module.utils.CommonAction;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@RunWith(SerenityRunner.class)
public class SearchRunner {

    // chrome, firefox, appium, remote
    @Managed
    WebDriver driver;

    SearchPage searchPage;
    CommonAction commonAction;

    @Test
    public void testUI() {
        searchPage.openPage();
        searchPage.filterByUserRating("4 & above (Very Good)");
        searchPage.filterByPrice("1000");
        searchPage.assertFilters("1000","4 & above (Very Good)");
        searchPage.selectHotel(1);
        commonAction.switchToOpenedTab(getDriver());
    }
}
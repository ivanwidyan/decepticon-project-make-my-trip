package com.decepticon.runner.test;

import com.decepticon.module.constant.Consts;
import com.decepticon.module.ui.HotelDetailPage;
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

    HotelDetailPage hotelDetailPage;

    CommonAction commonAction;

    @Test
    public void testUI() {
        searchPage.openPage();
        searchPage.filterByUserRating("4 & above (Very Good)");
        searchPage.filterByPrice("1000");
        searchPage.assertFilters("1000","4 & above (Very Good)");
        searchPage.newSelectHotel(5);
        commonAction.switchTab(Consts.SECOND_INDEX);

        System.out.println(getDriver().getCurrentUrl());
//        hotelDetailPage.openPage();
        hotelDetailPage.getTextRoomName("1");
        hotelDetailPage.getListRoomDetail("1");
        hotelDetailPage.getTextPrice("1", "1");
        hotelDetailPage.getListOption("1", "1");
        hotelDetailPage.getListIncluded("1", "1");
        hotelDetailPage.clickButtonSelectRoom("1", "1");
    }
}
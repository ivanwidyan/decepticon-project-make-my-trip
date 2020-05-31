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

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class SearchRunner {

    // chrome, firefox, appium, remote
    @Managed
    WebDriver driver;

    SearchPage searchPage;

    HotelDetailPage hotelDetailPage;

    CommonAction commonAction;

    private final String userRating = "4 & above (Very Good)";
    private final String price = "1000";

    @Test
    public void testUI() {
        searchPage.openPage();
        searchPage.clickButtonFilterByUserRatings(userRating);
        searchPage.dragSliderFilterMinPrice(price);

        List<String> appliedFilters = searchPage.getListTextFilter();
        System.out.println(appliedFilters);
        assertThat("min price filter is wrong",
                appliedFilters.contains("INR " + price + "-30000"), equalTo(true));

        assertThat("user rating filter is wrong",
                appliedFilters.contains(userRating), equalTo(true));

        searchPage.clickButtonHotelName(5);
        commonAction.switchTab(Consts.SECOND_INDEX);
    }
}
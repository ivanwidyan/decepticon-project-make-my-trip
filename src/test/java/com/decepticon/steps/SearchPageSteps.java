package com.decepticon.steps;

import com.decepticon.module.constant.Consts;
import com.decepticon.module.constant.ValueConsts;
import com.decepticon.module.ui.SearchPage;
import com.decepticon.module.utils.CommonAction;
import com.decepticon.module.utils.Utility;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author Gokul on 31 May,2020
 */
public class SearchPageSteps
{
    private SearchPage searchPage;
    private CommonAction commonAction;
    @Given("open search results page")
    public void openSearchResultsPage()
    {
        searchPage.openPage();
    }

    @When("at search results page filter by user rating as {string}")
    public void atSearchResultsPageFilterByUserRatingAs(String userRating)
    {
        searchPage.clickButtonFilterByUserRatings(userRating);
    }

    @Then("at search results page applied filters for user rating should be {string}")
    public void atSearchResultsPageAppliedFiltersForUserRatingShouldBe(String userRating)
    {
        List<String> appliedFilters = searchPage.getListTextFilter();
        assertThat("user rating filter is wrong",
                appliedFilters.contains(userRating), equalTo(true));
    }

    @When("at search results page filter by price from {string}")
    public void atSearchResultsPageFilterByPriceFrom(String price) {
        searchPage.dragSliderFilterMinPrice(price);
    }

    @Then("at search results page applied filters for price should be {string}")
    public void atSearchResultsPageAppliedFiltersForPriceShouldBe(String price) {
        List<String> appliedFilters = searchPage.getListTextFilter();
        System.out.println(appliedFilters);
        assertThat("min price filter is wrong",
                appliedFilters.contains("INR " + price + "-30000"), equalTo(true));
    }

    @When("at search results page click the {string}th hotel from the search results")
    public void atSearchResultsPageClickTheThHotelFromTheSearchResults(String numberOfHotel) {
        searchPage.clickButtonHotelName(Integer.valueOf(numberOfHotel));
    }

    @Then("at search results page tab is switched to the hotel detail page")
    public void atSearchResultsPageTabIsSwitchedToTheHotelDetailPage()
    {
        commonAction.switchTab(Consts.SECOND_INDEX);
    }

    @When("at search results page user select the currency")
    public void atSearchResultsPageUserSelectTheCurrency() {
        searchPage.selectCurrency();
    }

    @Then("at search results page selected currency is shown at the top of the page")
    public void atSearchResultsPageSelectedCurrencyIsShownAtTheTopOfThePage() {
        searchPage.assertCurrency(ValueConsts.CURRENCY);
    }
}

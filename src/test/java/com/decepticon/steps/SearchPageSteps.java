package com.decepticon.steps;

import com.decepticon.module.ui.SearchPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Gokul on 31 May,2020
 */
public class SearchPageSteps
{
    private SearchPage searchPage;
    @Given("open search results page")
    public void openSearchResultsPage()
    {
        searchPage.openPage();
    }

    @When("at search results page filter by user rating as {string}")
    public void atSearchResultsPageFilterByUserRatingAs(String userRating)
    {
        searchPage.filterByUserRating(userRating);
    }

    @Then("at search results page applied filters for user rating should be {string}")
    public void atSearchResultsPageAppliedFiltersForUserRatingShouldBe(String userRating)
    {
    }

    @When("at search results page filter by price from {string}")
    public void atSearchResultsPageFilterByPriceFrom(String price) {
        
        
    }

    @Then("at search results page applied filters for price should be {string}")
    public void atSearchResultsPageAppliedFiltersForPriceShouldBe(String price) {
    }

    @When("at search results page click the {string}th hotel from the search results")
    public void atSearchResultsPageClickTheThHotelFromTheSearchResults(String numberOfHotel) {
    }

    @Then("at search results page tab is switched to the hotel detail page")
    public void atSearchResultsPageTabIsSwitchedToTheHotelDetailPage() {
    }
}

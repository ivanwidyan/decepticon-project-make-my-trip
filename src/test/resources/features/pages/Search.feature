@SearchPageFeature @MakeMyTrip @Component @UI
Feature: Search Page Feature

  @Positive
  Scenario: Verify search page should be success
    Given open search results page
    When  at search results page user select the currency equals to "INR - Indian Rupee"
    When  at search results page filter by user rating as "4 & above (Very Good)"
    Then  at search results page applied filters for user rating should be "4 & above (Very Good)"
    When  at search results page filter by price from "1000"
    Then  at search results page applied filters for price should be "1000"
    When  at search results page click the 5th hotel from the search results
    Then  at search results page tab is switched to the hotel detail page
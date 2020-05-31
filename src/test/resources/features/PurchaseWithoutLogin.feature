@PurchaseWithoutLoginFeature @MakeMyTrip @Integration @UI
Feature: Purchase Feature

  @Positive
  Scenario: Purchase hotel in Make My Trip web scenario
    Given open home page
    When  at home page click button Hotel
    When  at home page click button City
    When  at home page city section fill text box city with 'Indonesia'
    When  at home page city section click list button City equals to 'Bali'
    When  at home page click button Check In equals to '17 June'
    When  at home page click button Check Out equals to '20 June'
    When  at home page click button Room & Guest
    When  at home page room section click button Adults equals to '2'
    When  at home page room section click button Children equals to '2'
    When  at home page room section click button Add Another Room
    When  at home page room section click button Adults equals to '2'
    When  at home page room section click button Children equals to '2'
    When  at home page room section click button Apply
    When  at home page click button Travelling For
    When  at home page travel section click list button Travelling For equals to 'Work'
    When  at home page click button Search

    When  at search results page user select the currency equals to "INR - Indian Rupee"
    When  at search results page filter by user rating as "4 & above (Very Good)"
    Then  at search results page applied filters for user rating should be "4 & above (Very Good)"
    When  at search results page filter by price from "1000"
    Then  at search results page applied filters for price should be "1000"
    When  at search results page click the 5th hotel from the search results
    Then  at search results page tab is switched to the hotel detail page

    When  at hotel detail page get text Hotel name
    And   at hotel detail page Hotel name should be correct
    When  at hotel detail page get text Room Name for room number equals to '1'
    When  at hotel detail page get list Room Detail for room number equals to '1'
    When  at hotel detail page get text Price for room number equals to '1' and option number equals to '1'
    When  at hotel detail page get list Option for room number equals to '1' and option number equals to '1'
    When  at hotel detail page get list Included in Fee for room number equals to '1' and option number equals to '1'
    When  at hotel detail page click button Select Room for room number equals to '1' and option number equals to '1'

    Given at room page store the hotel name date to the data
    And   at room page store the room name date to the data
    When  at room page fill text box first name with 'We are'
    When  at room page fill text box last name with 'Deception'
    When  at room page fill text box email with 'deception@mailinator.com'
    When  at room page select option code phone number with '+62'
    When  at room page fill text box phone number with '81234567890'
    When  at room page click popup leaving page if show up
    When  at room page fill text box pan with '101'
    When  at room page click checkbox special request equals 'Smoking room' if visible
    When  at room page click checkbox special request equals 'Large bed' if visible
    When  at room page click checkbox donation
    Then  at room page store the total amount date to the data
    When  at room page click button paynow

    Then at book page hotel name should correct
    And  at book page room name should correct
    And  at book page check in date should correct
    And  at book page check out date should correct
    And  at book page total adult guest should correct
    And  at book page total children guest should correct
    And  at book page total amount should correct
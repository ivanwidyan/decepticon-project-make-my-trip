@PurchaseFeature @MakeMyTrip @UI
Feature: Purchase Feature

  @Positive
  Scenario: Login to Make My Trip scenario
    Given open home page
    When  at home page click button login
    When  at home page login popup fill text box username with 'gocoolmmt@mailinator.com'
    When  at home page login popup click button continue
    When  at home page login popup click button continue
    When  at home page login popup fill text box password with 'testing@9091'
    When  at home page login popup click button continue
    When  at home page login popup click button close

  @Positive @asdads
  Scenario: Make My Trip purchase scenario
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


  @Positive @hoteldetail
  Scenario: Make My Trip purchase scenario HotelDetail
    Given open hotel Detail Page
    When  at hotel detail page get text Hotel name
    When  at hotel detail page get text Room Name for room number equals to '1'
    When  at hotel detail page get list Room Detail for room number equals to '1'
    When  at hotel detail page get text Price for room number equals to '1' and option number equals to '1'
    When  at hotel detail page get list Option for room number equals to '1' and option number equals to '1'
    When  at hotel detail page get list Included in Fee for room number equals to '1' and option number equals to '1'
    When  at hotel detail page click button Select Room for room number equals to '1' and option number equals to '1'
    Given open hotel Detail Page Multiple Room
    When  at hotel detail page get text Hotel name
    When  at hotel detail page get text Room Name for room number equals to '1'
    When  at hotel detail page get list Room Detail for room number equals to '1'
    When  at hotel detail page get text Price For Multiple People for room number equals to '1' and option number equals to '1'
    When  at hotel detail page get list Multi Option for room number equals to '1' and option number equals to '1'
    When  at hotel detail page get list Included in Fee for Multi People for room number equals to '1' and option number equals to '1'
    When  at hotel detail page click button People Count Selector for room number equals to '1' and option number equals to '1'
    When  at hotel detail page click button Select People Count List for option number equals to '1'
    When  at hotel detail page click button Add Room for room number equals to '1' and option number equals to '1'
    When  at hotel detail page get text Total Price For Multiple People
    When  at hotel detail page click button Add Room for room number equals to '1' and option number equals to '1'
    When  at hotel detail page get text Total Price For Multiple People
    When  at hotel detail page click button Add Room for room number equals to '1' and option number equals to '1'
    When  at hotel detail page get text Total Price For Multiple People
    When  at hotel detail page click button Add Room for room number equals to '1' and option number equals to '1'
    When  at hotel detail page get text Total Price For Multiple People
    When  at hotel detail page click button Review Detail

  @Positive @Search
  Scenario: Make My Trip purchase scenario SearchPage
    Given open search results page
    When  at search results page filter by user rating as "4 & above (Very Good)"
    Then  at search results page applied filters for user rating should be "4 & above (Very Good)"
    When  at search results page filter by price from "1000"
    And   at search results page user select the currency
    And   at search results page selected currency is shown at the top of the page
    Then  at search results page applied filters for price should be "1000"
    When  at search results page click the 10th hotel from the search results
    Then  at search results page tab is switched to the hotel detail page

  @Positive @SearchandHdetail
  Scenario: Make My Trip purchase scenario SearchPage and Hotel Detail
    Given open home page
    When  at home page click button login
    When  at home page login popup fill text box username with 'gocoolmmt@mailinator.com'
    When  at home page login popup click button continue
    When  at home page login popup click button continue
    When  at home page login popup fill text box password with 'testing@9091'
    When  at home page login popup click button continue
    When  at home page login popup click button close

    When  at home page click button Hotel
    When  at home page click button City
    When  at home page city section fill text box city with 'Indonesia'
    When  at home page city section click list button City equals to 'Jakarta'
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

    When  at search results page filter by user rating as "4 & above (Very Good)"
    Then  at search results page applied filters for user rating should be "4 & above (Very Good)"
    When  at search results page filter by price from "1000"
    Then  at search results page applied filters for price should be "1000"
    When  at search results page click the 10th hotel from the search results
    Then  at search results page tab is switched to the hotel detail page

    When  at hotel detail page get text Hotel name
    When  at hotel detail page get text Room Name for room number equals to '1'
    When  at hotel detail page get list Room Detail for room number equals to '1'
    When  at hotel detail page get text Price for room number equals to '1' and option number equals to '1'
    When  at hotel detail page get list Option for room number equals to '1' and option number equals to '1'
    When  at hotel detail page get list Included in Fee for room number equals to '1' and option number equals to '1'
    When  at hotel detail page click button Select Room for room number equals to '1' and option number equals to '1'
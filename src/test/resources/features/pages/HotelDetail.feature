@HotelDetailPageFeature @MakeMyTrip @Component @UI
Feature: Purchase Feature

  @Positive
  Scenario: Verify hotel detail page should be success
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
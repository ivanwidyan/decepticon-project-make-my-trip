@PurchaseFeature @MakeMyTrip @UI
Feature: Purchase Feature

#  @Positive
#  Scenario: Make My Trip purchase scenario
#    Given open home page
#    When  at home page click button Hotel
##    When  at home page click button Login or Create Account
#  # When  at home page login popup type text box email with ''
##    When  at home page login popup click button Continue
#    When  at home page click button City
#    When  at home page city section fill text box city with 'Indonesia'
#    When  at home page city section click list button City equals to 'Bali'
#    When  at home page click button Check In equals to '17 June'
#    When  at home page click button Check Out equals to '20 June'
#    When  at home page click button Room & Guest
#    When  at home page room section click button Adults equals to '2'
#    When  at home page room section click button Children equals to '2'
#    When  at home page room section click button Add Another Room
#    When  at home page room section click button Adults equals to '2'
#    When  at home page room section click button Children equals to '2'
#    When  at home page room section click button Apply
#    When  at home page click button Travelling For
#    When  at home page travel section click list button Travelling For equals to 'Work'
#    When  at home page click button Search


  @Positive
  Scenario: Make My Trip purchase scenario HotelDetail
    Given open hotel Detail Page
    When  at hotel detail page get text Room Name for room number equals to '1'
    When  at hotel detail page get list Room Detail for room number equals to '1'
    When  at hotel detail page get text Price for room number equals to '1' and option number equals to '1'
    When  at hotel detail page get list Option for room number equals to '1' and option number equals to '1'
    When  at hotel detail page get list Included in Fee for room number equals to '1' and option number equals to '1'
    When  at hotel detail page click button Select Room for room number equals to '1' and option number equals to '1'
    Given open hotel Detail Page Multiple Room
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

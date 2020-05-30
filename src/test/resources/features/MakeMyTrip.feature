@PurchaseFeature @MakeMyTrip @UI
Feature: Purchase Feature

  @Positive
  Scenario: Make My Trip purchase scenario
    Given open home page
    When  at home page click button Hotel
#    When  at home page click button Login or Create Account
  # When  at home page login popup type text box email with ''
#    When  at home page login popup click button Continue
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
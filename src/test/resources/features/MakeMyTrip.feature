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
    When  at home page fill text box city with 'Indonesia'
    When  at home page click list button City equals to ''
    When  at home page click button Hotel
    When  at home page click button Hotel
    When  at home page click button Hotel

  checkTheDate("June", "17");
  homePage.clickDate("June", "17");
  checkTheDate("June", "20");
  homePage.clickDate("June", "20");
  homePage.clickSectionRoom();
  int t = 0;
  while(t < 1) {
  homePage.clickNumberOfAdults("2");
  homePage.clickNumberOfChildren("2");
  homePage.clickButtonAddRooms();
  t++;
  }
  homePage.clickButtonApplyRoom();
  homePage.clickSectionTravelFor();
  homePage.clickSelectTravelFor("Work");
  homePage.clickButtonSearch();
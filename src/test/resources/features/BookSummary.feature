@BookingSummaryFeature
  Feature: Booking summary page

    Scenario: the data should be correct
      Given open book page
      Then at book page hotel name should correct
      And  at book page text address should correct
      And  at book page rating should correct
      And  at book page check in date should correct
      And  at book page check in day should correct
      And  at book page check out date should correct
      And  at book page check out day should correct
      And  at book page total guest should correct
      And  at book page total amount should correct
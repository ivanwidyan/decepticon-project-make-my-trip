@RoomPageFeature @MakeMyTrip @Component @UI
  Feature: Room Page Feature

    Scenario: Verify room page should be success
      Given open room page
      Given at room page store the check in date to the data
      And   at room page store the check out date to the data
      And   at room page store the hotel name date to the data
      And   at room page store the total guests date to the data
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
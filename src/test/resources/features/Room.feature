@RoomFeature
  Feature: Room test

    Scenario: Room Test
      Given open room page
      When  at room page fill text box first name with 'We are'
      When  at room page fill text box last name with 'Deception'
      When  at room page fill text box email with 'Email'
      When  at room page click button code phone number
      When  at room page click list button code phone number with '+62'
      When  at room page fill text box phone number with '81234567890'
      When  at room page fill text box pan with '101'
      When  at room page click checkbox special request equals 'Smoking room'
      When  at room page click checkbox special request equals 'Large bed'
      When  at room page click checkbox donation
      When  at room page click button paynow
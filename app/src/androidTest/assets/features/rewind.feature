Feature: Rewind functionality

  In order to go back and read text that I misunderstood
  As a user
  I want to be able to jump back a sentence or paragraph

  Scenario: Rewind back a sentence
    Given I have content://com.android.externalstorage.documents/document/primary%3Amoby-dick.epub open
      And The word Some is displayed
    When I click rewind
    Then The word Call should be displayed

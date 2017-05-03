# Took out details such as chapter and page number to make the tests easier to read

Feature: Rewind functionality

  In order to go back and read text that I misunderstood
  As a user
  I want to be able to jump back a sentence or paragraph

  # Make sure you have epubs/moby-dick.epub at "/sdcard/moby-dick.epub" on your Android device
  Scenario: Rewind back a sentence
    Given I have content://com.android.externalstorage.documents/document/primary%3Amoby-dick.epub open
      And The word Some is displayed
    When I click rewind sentence
    Then The word Call should be displayed

  Scenario: Rewind back a paragraph
    Given I have content://com.android.externalstorage.documents/document/primary%3Amoby-dick.epub open
    And The word commerce is displayed
    When I click rewind paragraph
    Then The word Call should be displayed
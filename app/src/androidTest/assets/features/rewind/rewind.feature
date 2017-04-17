Feature: Rewind functionality for Glance Reader

  In order to go back and read text that I misunderstood
  As a user
  I want to be able to jump back a sentence or paragraph

  Scenario: Rewind back a sentence
    Given I have an epub3 version of Moby Dick loaded into the reader
    And the word "Some" from second sentence of Chapter 1 is displayed
    When I click the rewind sentence button
    Then the word "Call" from the first sentence of Chapter 1 should be displayed

  Scenario: Rewind back a paragraph
    Given I have an epub3 version of Moby Dick loaded into the reader
    And the word "There" from the second paragraph of Chapter 1 is displayed
    When I click the rewind paragraph button
    Then the word "Call" from the first paragraph of Chapter 1 should be displayed
Feature: Rewind functionality for Glance Reader

  In order to go back and read text that I misunderstood
  As a user
  I want to be able to jump back a sentence or paragraph

  Scenario: Rewind back a sentence
    Given I have a book open
    When I click rewind
    Then The word should be displayed

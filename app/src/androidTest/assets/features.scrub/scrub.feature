Feature: "Scrubbing" through document

  In order for me to fully read and understand documents and books
  As a user
  I would like to move my place in the text both forwards and backwards

  Scenario: Scrub forward through text
    Given I have loaded a news article into the Glance Reader
    When I slide the Scrub bar forward 10%
    Then then the word that should be displayed is 10% far

  Scenario: User wants to scrub backwards through the document

    Given the user has loaded in an article/text file/link/ebook/etc. to read from using the Glance reader
    When the user slides the bar backwards
    And document is not at beginning
    Then the reader should move to that position in document
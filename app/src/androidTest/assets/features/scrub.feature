Feature: "Scrubbing" through document

  In order for me to fully read and understand documents and books
  As a user
  I would like to move my place in the text both forwards and backwards

  Scenario: Scrub from beginning of text to 50%
    Given I have the link http://www.foxnews.com/us/2017/05/03/controversy-erupts-after-colorado-animal-sanctuary-kills-all-its-animals.html open
    And I am at 0 percent of the article
    When I slide the Scrub bar forward 50 percent
    Then the word that should be displayed is at the 50 percent point of the entire article

  Scenario: Scrub from 50% of the way through an article to the start

    Given I have the link http://www.foxnews.com/us/2017/05/03/controversy-erupts-after-colorado-animal-sanctuary-kills-all-its-animals.html open
    And I am at 50 percent of the article
    When I slide the Scrub bar back to 0 percent
    Then the first word in the article should be displayed
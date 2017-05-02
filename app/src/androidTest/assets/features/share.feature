Feature: Being able to share a website or selected text to the application

  In order to share something to the application
  As a user
  I want to select a share option to send GlanceReader what I wish to read.

  Scenario: Sharing a webpage to GlanceReader
    Given The webpage called http://www.google.com is valid
    When A webpage is shared to GlanceReader
    Then The application will open the website and begin reading

  Scenario:  Sharing a selected text to GlanceReader
    Given The selected text is readable
    When A selected text is shared to GlanceReader
    Then The application will begin reading the selected text
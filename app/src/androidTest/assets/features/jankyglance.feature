# I rephrased the original to be more descriptive and terse

Feature: Use JankyGlance Backend

  In order to use the web functionality of the app
  As a system
  I need to use endpoints to the new JankyGlance backend

  Scenario: Connect to the JankyGlance backend
    Given The application is started
    When I connect to the backend
    Then I should be using the endpoint: https://1yae9gfwab.execute-api.us-east-1.amazonaws.com/dev/40805955111ac2e85631facfb362f067



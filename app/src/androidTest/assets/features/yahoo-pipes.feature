# This was originally called JankyGlance Endpoints. I rephrased it to be more descriptive

Feature: Yahoo! Pipes Compatibility

  In order to use Yahoo! Pipes as the backend
  As a system
  I need to use new endpoints

  Scenario: Connect to the backend
    Given The application is started
    When I connect to the backend
    Then I should be using the endpoint: https://1yae9gfwab.execute-api.us-east-1.amazonaws.com/dev/40805955111ac2e85631facfb362f067



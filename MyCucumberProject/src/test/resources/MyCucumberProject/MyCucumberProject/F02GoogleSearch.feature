Feature: Google Search

  Scenario: To validate search functionality on Google
    Given Launch Google
    When Enter keyword to search in search box
    And Hit enter
    Then A valid search result should display

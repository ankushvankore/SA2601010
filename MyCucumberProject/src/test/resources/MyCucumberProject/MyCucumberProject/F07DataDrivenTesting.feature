Feature: Data driven testing on Orange HRM application

  Scenario Outline: To validate login functionality
    Given Launch Orange HRM Application
    When Enter user name as "<UserName>"
    When Enter password as "<Password>"
    And Click on submit button
    Then Dashboard page should display

    Examples: 
      | UserName | Password  |
      | admin    | admin123  |
      | nishma   | nishma123 |
      | admin    | admin123  |
      | aniket   | aniket123 |

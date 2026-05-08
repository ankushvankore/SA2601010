#Demo for multiple test scenarios
Feature: Expand Testing Login

  #Background will allow to execute code of Given statement before every scenario
  Background: 
    Given Open expand testing site

  Scenario: To validate login functionality with valid data
    When Enter valid user name
    When Enter valid password
    And Click on Login button
    Then Home page should display

  Scenario: To validate login functionality with invalid data
    When Enter invalid user name
    When Enter invalid password
    And User will click on login button
    Then Error message should display

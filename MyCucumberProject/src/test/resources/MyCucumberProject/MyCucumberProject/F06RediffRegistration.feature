Feature: Rediff registration process with multiple values

  Scenario: To validate registration process
    Given Launch rediff registration page
    When Enter the following data
      | Aniket Jadhav | aniket_jadhav | aniket@123  | 10 | MAY | 2000 | Male   |
      | Akansha Saraf | akanshasaraf  | akansha@123 | 29 | SEP | 2000 | Female |
    #Data Table
    Then Registration process is successful

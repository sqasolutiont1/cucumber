Feature: Test Automation for Forms
  Scenario Outline: Fillout wizard
    Given Wizard. I navigate to Wizard
    When Wizard. Fillout the first page with: "<First Name>" and "<Last name>"
    And Wizard. I press Next Button
    Then Wizard. I Fillout the second Page with: "<Street Address>", "<City>", "<State>", "<Zip>"
    And Wizard. I press Next Button
    Then Wizard. I press Submit button
    And Wizard. I accept the alert
        Examples:
      |First Name  | Last name | Street Address| City|State|Zip|
      |First Name  | Last name | Street Address| City|State|Zip|
      |First Name  | Last name | Street Address| City|State|Zip|


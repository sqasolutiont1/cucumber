Feature: Wizard
  Scenario: Fillout all the steps
    Given I navigate to Wizard
    When Fillout the first page with: "First Name" and " Last name"
    And I will wait for "10" seconds
    Then I press Next Button
    When I Fillout the second Page with: "streetAddress", "city", "state", "zip"
    And I will wait for "10" seconds
    Then I press Next Button


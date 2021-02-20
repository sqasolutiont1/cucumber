Feature: Wizard
  Scenario: Fillout Step one
    Given I navigate to Wizard
    When Fillout the first page with: "First Name" and " Last name"
    Then I press Next Button

Feature: Wizard
  Scenario: Fillout all the steps
    Given I navigate to Wizard
    And I verify that I an on the correct Step and I see the label: "Enter first step data"
    When Fillout the first page with: "First Name" and " Last name"
    Then I press Next Button
    And I verify that I an on the correct Step and I see the label: "Enter second step data"
    When I Fillout the second Page with: "streetAddress", "city", "state", "zip"
    Then I press Next Button
    And I verify that I an on the correct Step and I see the label: "Finish last step"
    When I check First Name, I see: "Last Name"
    #When I check Last Name, I see: "Last Name"
    And I will wait for "10" seconds




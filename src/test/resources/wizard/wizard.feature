Feature: Wizard
  Scenario: Fillout all the steps
    Given Wizard. I navigate to Wizard
    And Wizard. I verify that I an on the correct Step and I see the label: "Enter first step data"
    When Wizard. Fillout the first page with: "First Name" and " Last name"
    Then Wizard. I press Next Button
    And Wizard. I verify that I an on the correct Step and I see the label: "Enter second step data"
    When Wizard. I Fillout the second Page with: "streetAddress", "city", "state", "zip"
    Then Wizard. I press Next Button
    And Wizard. I verify that I an on the correct Step and I see the label: "Finish last step"




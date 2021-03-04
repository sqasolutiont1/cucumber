Feature: Test Automation for Forms
Background:
  Given Forms. I navigate to Forms

  Scenario: the basic form
    When Forms. I fill in email with data with "invalid" values from data source
    When Forms. I fill in email with data with "valid" values from data source
    Then Forms. I fill out password:""
    And Forms. I attach file:"/src/main/resources/zipFile.zip" to the form


  Scenario: Select items in selectors
    When Forms. I select from multiple element: "2", "3", "4"

  Scenario: Check uncheck checkboxes
    When Forms. I check if the check box is checked

Feature: Test Automation for Forms

  Scenario: the basic form

    When Forms. I navigate to Forms
    When Forms. I fill in email with data with "invalid" values from data source
    When Forms. I fill in email with data with "valid" values from data source
    Then Forms. I fill out password:""
    And Forms. I attach file:"/src/main/resources/zipFile.zip" to the form
  #Scenario Attach file to the form
  #Scenario: Select items in selectors
  #Scenario: Check uncheck checkboxes


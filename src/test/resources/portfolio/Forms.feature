Feature: Test Automation for Forms

  Scenario: the basic form

    When Forms. I navigate to Forms
    When I fill in email with data with "valid" values from data source
    When I fill in email with data with "invalid" values from data source
  #Scenario Attach file to the form
  #Scenario: Select items in selectors
  #Scenario: Check uncheck checkboxes


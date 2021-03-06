Feature: Test Automation for Forms
  Background:
    Given Forms. I navigate to Masks
  Scenario: check masks rules
    When Mask. Fill out Date : "11112000"
    Then Mask. Date in the field should be : "11/11/2000"


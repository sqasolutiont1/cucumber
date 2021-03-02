Feature: Test Automation for Forms

  Background:
    Given Navigate to tables

  Scenario: fillout login form
    When I check if I'm on the tables page
    Then I check the list of the elements in the Header

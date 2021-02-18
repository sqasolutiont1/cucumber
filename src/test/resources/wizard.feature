Feature: Wizard
  Scenario Outline: eating
    Given I nav
    When Fillut the first page with <FirstName>, <LastName>
    Then I fill out seond page with <....>
    Examples:
      | FirstName | LastName | left   |
      |    12     |   5      |    7   |
      |    20     |   5      |   15   |
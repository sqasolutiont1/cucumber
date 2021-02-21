Feature: Test Automation for Forms

  Background:
    Given Navigate to tables

  Scenario: fillout login form
    When I check if I'm on the tables page
    Then I check the list of the elements in the Header
    And I print all the table
    When I select 10 elements on the page //https://www.toolsqa.com/selenium-webdriver/dropdown-in-selenium/
    When I select 25 elements on the page
    When I select 50 elements on the page
    When I select 100 elements on the page
    Then I search for: "Jennifer Chang"
    And I get Search results: "Jennifer Chang|Regional Director|Singapore|28|2010/11/14|$357,650"

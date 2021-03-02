Feature: I'm demonstrating ow I'm working with WebElements
  Background: Navigate to the A&N page
    Given I navigate to alerts and notifications

  Scenario Outline: Add/Read notification
    When I am on the Alert And notifications Page
    Then I fill out new notification message: "<Message>"
    Then I read the notification message : "<Message>"
    Then I will wait for "3" seconds
    Examples:
      |Message        |
      |First message  |
      |Second message |
      |Third message  |
      |Fourth message |


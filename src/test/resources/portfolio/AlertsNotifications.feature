Feature: I'm demonstrating ow I'm working with WebElements
  Background: Navigate to the A&N page
    Given I navigate to alerts and notifications

  Scenario: Add/Read notification
    When I am on the Alert And notifications Page
    Then I fill out new notification message: "First message"
    Then I read the notification message : "First message"

  Scenario Outline: Add/Read notification Examples
   When I am on the Alert And notifications Page
    Then I fill out new notification message: "<Message>"
    Then I read the notification message : "<Message>"
    Examples:
      |Message        |
      |First message  |
      |Second message |
      |Third message  |
      |Fourth message |

  Scenario: Add/Read notification Tables
    When I am on the Alert And notifications Page
    Then I fill out and check notification message
      |First message  |
      |Second message |
      |Third message  |
      |Fourth message |


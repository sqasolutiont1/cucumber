Feature: I'm demonstrating ow I'm working with WebElements
Background: Modals.
  Given Modals. I navigate to Modals
#  Scenario: Open default Modal
#  Scenario: Open and filout modal form
#  Scenario: Open and scroll scrolling modal
#
#  Scenario: Read Popovers
  Scenario: Read tooltips
    When Modals. I hover mouse over the button1
    Then Modals. I see the tooltip: "Tooltip on right"



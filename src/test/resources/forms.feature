Feature: Test Automation for Forms

  Background:
    Given Navigate to "http://authenticgoods.co/wrapbootstrap/themes/neuboard-v1.4.3/Angular_full_version/#/forms/components"

  Scenario Outline: fillout login form
    When I fill in email: "<Email>"
    Examples:
      |Email                   |
      |jwdnfwekjbfew@mail.jh |
      |12341231231231@mail.jh |
      |dfvdsgbfgfbrstgbfgb@mail.jh |

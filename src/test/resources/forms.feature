Feature: Test Automation for Forms

  Background:
    Given Navigate to "http://authenticgoods.co/wrapbootstrap/themes/neuboard-v1.4.3/Angular_full_version/#/forms/components"

  Scenario: fillout login form
    When I fill in email: "jwdnfwekjbfew@mail.jh"
    Then I fill in password: "dferfgerf"
    Then I attach the file: "C:\Users\vkame\OneDrive\Desktop\map-of-texas.jpg"
    And I verify that I see some kind of element
    And I press on Submit button

  Scenario: fillout login form1
    When I fill in email: "jwdnfwekjbfew@mail.jh"
    Then I fill in password: "dferfgerf"
    Then I attach the file: "C:\Users\vkame\OneDrive\Desktop\map-of-texas.jpg"
    And I verify that I see some kind of element
    And I press on Submit button
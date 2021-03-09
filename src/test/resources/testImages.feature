Feature: Test if all images present on the page
  Scenario: Check if all images on the page for the specified website
    When Images. I navigate to:"https://www.demoqa.com/broken"
    Then Images. I check if all the images in place.
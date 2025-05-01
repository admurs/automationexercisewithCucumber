@All
Feature: Page Scroll Functionality Verification

  Scenario: Verify page scroll down and scroll up functionality
    Given I launch the browser
    When I navigate to url automationexercise
    Then I verify that home page is visible successfully

    When I scroll down page to bottom
    Then I verify text SUBSCRIPTION

    When I scroll up page to top
    Then I verify that page is scrolled up and Full-Fledged practice website for Automation Engineers text is visible on screen
@All
Feature: Page Scroll and Subscription Verification

  Scenario: Verify page scroll functionality and subscription visibility
    Given I launch the browser
    When I navigate to url automationexercise
    Then I verify that home page is visible successfully

    When I scroll down page to bottom
    Then I verify text SUBSCRIPTION

    When I click on arrow at bottom right side to move upward
    Then I verify that page is scrolled up and Full-Fledged practice website for Automation Engineers text is visible on screen
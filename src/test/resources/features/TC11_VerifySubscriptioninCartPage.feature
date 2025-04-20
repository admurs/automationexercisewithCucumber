@All
Feature: Cart Page Subscription Verification

  Scenario: Verify subscription from cart page
    Given I launch the browser
    When I navigate to url automationexercise
    Then I verify that home page is visible successfully
    When I click Cart button
    And I scroll down to footer
    Then I verify text SUBSCRIPTION
    When I enter email address in input and click arrow button
    Then I verify success message You have been successfully subscribed! is visible
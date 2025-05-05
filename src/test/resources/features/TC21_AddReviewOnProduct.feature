@All
Feature: Product Review Submission

  Scenario: TC21 Submit and verify product review
    Given I launch the browser
    When I navigate to url automationexercise
    And I click on Products button
    Then I verify user is navigated to ALL PRODUCTS page successfully
    When I click on View Product button
    Then I verify Write Your Review is visible
    When I enter name, email and review
    And I click Submit button
    Then I verify success message Thank you for your review.
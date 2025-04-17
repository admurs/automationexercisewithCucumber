@All
Feature: Test Cases Page Navigation
  As a website user
  I want to access the test cases page
  So that I can verify the navigation functionality

  Scenario: Verify successful navigation to test cases page
    Given I launch the browser
    When I navigate to url automationexercise
    Then I verify that home page is visible successfully

    When I click on Test Cases button
    Then I verify user is navigated to test cases page successfully
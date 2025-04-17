@RegisterUser
Feature: User Login and Account Deletion
  As a registered user
  I want to login and delete my account
  To verify account management functionality

  Scenario: Successful login and account deletion
    Given I launch the browser
    When I navigate to url automationexercise
    Then I verify that home page is visible successfully

    When I click on Signup-Login button
    Then I verify that Login to your account is visible

    When I enter correct email address and password
    And I click login button
    Then I verify that Logged in as username is visible

    When I click Delete Account button
    Then I verify that ACCOUNT DELETED! is visible
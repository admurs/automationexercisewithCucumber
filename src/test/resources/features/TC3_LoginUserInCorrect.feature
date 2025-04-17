@All
Feature: User Login with Invalid Credentials
  As a user
  I want to attempt login with invalid credentials
  So that I can verify the systems error handling for incorrect login attempts

  Scenario: Failed login attempt with incorrect credentials
    Given I launch the browser
    When I navigate to url automationexercise
    Then I verify that home page is visible successfully

    When I click on Signup-Login button
    Then I verify that Login to your account is visible

    When I enter incorrect email address and password
    And I click login button
    Then I verify error Your email or password is incorrect! is visible
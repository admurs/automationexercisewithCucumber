@RegisterUser
Feature: User Login and Logout Functionality
  As a registered user
  I want to login and logout from my account
  So that I can verify the authentication workflow

  Scenario: TC4 Successful login and logout
    Given I launch the browser
    When I navigate to url automationexercise
    Then I verify that home page is visible successfully

    When I click on Signup-Login button
    Then I verify that Login to your account is visible

    When I enter correct email address and password
    And I click login button
    Then I verify that Logged in as username is visible

    When I click Logout button
    Then I verify that user is navigated to login page

      #Aşağıdaki caseler logout yapan kullanıcının silinmesi için eklenmiştir.
    When I enter correct email address and password
    And I click login button

    When I click Delete Account button
    Then I verify that ACCOUNT DELETED! is visible
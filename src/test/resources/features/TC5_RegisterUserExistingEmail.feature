@RegisterUser
Feature: User Registration with Existing Email
  As a new user
  I want to attempt registration with an existing email
  So that I can verify the system prevents duplicate registrations

  Scenario: Registration attempt with existing email
    Given I launch the browser
    When I navigate to url automationexercise
    Then I verify that home page is visible successfully

    When I click on Signup-Login button
    Then I verify that New User Signup! is visible

    When I enter name and already registered email address
    And I click Signup button
    Then I verify error Email Address already exist! is visible

    #Aşağıdaki caseler logout yapan kullanıcının silinmesi için eklenmiştir.
    When I enter correct email address and password
    And I click login button

    When I click Delete Account button
    Then I verify that ACCOUNT DELETED! is visible
@All
Feature: User Registration and Account Deletion
  As a user of Automation Exercise
  I want to register a new account and then delete it
  So that I can verify the account lifecycle functionality

  Scenario: TC1 Successful user registration and account deletion
    Given I launch the browser
    When I navigate to url automationexercise
    Then I verify that home page is visible successfully

    When I click on Signup-Login button
    Then I verify that New User Signup! is visible

    When I enter name and email address
    And I click Signup button
    Then I verify that ENTER ACCOUNT INFORMATION is visible

    When I fill details: Title, Name, Email, Password, Date of birth
    And I select checkbox Sign up for our newsletter!
    And I select checkbox Receive special offers from our partners!
    And I fill details: First name, Last name, Company, Address, AddressDetail, Country, State, City, Zipcode, Mobile Number
    And I click Create Account button
    Then I verify that ACCOUNT CREATED! is visible

    When I click Create Continue button
    Then I verify that Logged in as username is visible

    When I click Delete Account button
    Then I verify that ACCOUNT DELETED! is visible
    And I click Delete Continue button
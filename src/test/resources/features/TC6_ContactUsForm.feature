@All
Feature: Contact Us Form Functionality
  As a user
  I want to use the contact form
  So that I can verify its functionality

  Scenario: Complete contact form process
    Given I launch the browser
    When I navigate to url automationexercise
    Then I verify that home page is visible successfully

    When I click on Contact Us button
    Then I verify that GET IN TOUCH is visible

    When I enter name, email, subject and message
    And I upload file
    And I click Submit button
    And I click OK button
    Then I verify success message Success! Your details have been submitted successfully. is visible

    When I click Home button
    Then I verify that landed to home page successfully
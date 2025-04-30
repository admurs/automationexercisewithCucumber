@All
Feature: End-to-End Account and Checkout Process

  Scenario: Complete user registration, checkout verification, and account deletion
    Given I launch the browser
    When I navigate to url automationexercise
    Then I verify that home page is visible successfully

    When I click on Signup-Login button
    And I fill all details in Signup and create account
    Then I verify ACCOUNT CREATED! and click Continue button
    And I verify Logged in as username at top

    When I add products to cart
    And I click View Cart button
    Then I verify that cart page is displayed

    When I click Proceed To Checkout
    Then I verify that the delivery address is same address filled at the time registration of account
    And I verify that the billing address is same address filled at the time registration of account

    When I click Delete Account button
    Then I verify ACCOUNT DELETED! and click Continue button
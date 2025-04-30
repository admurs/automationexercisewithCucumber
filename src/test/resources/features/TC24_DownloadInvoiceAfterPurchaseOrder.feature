@All
Feature: Complete E-Commerce Purchase Flow with Account Creation

  Scenario: End-to-end purchase process with account creation and invoice download
    Given I launch the browser
    When I navigate to url automationexercise
    Then I verify that home page is visible successfully

    When I add products to cart
    And I click View Cart button
    Then I verify that cart page is displayed

    When I click Proceed To Checkout
    And I click Register-Login button
    And I fill all details in Signup and create account
    Then I verify ACCOUNT CREATED! and click Continue button
    And I verify Logged in as username at top

    When I click Cart button
    And I click Proceed To Checkout button
    Then I verify Address Details and Review Your Order

    When I enter description in comment text area and click Place Order
    And I enter payment details: Name on Card, Card Number, CVC, Expiration date
    And I click Pay and Confirm Order button
    Then I verify success message Your order has been placed successfully!

    When I click Download Invoice button and verify invoice is downloaded successfully
    And I click Continue button
    And I click Delete Account button
    Then I verify ACCOUNT DELETED! and click Continue button
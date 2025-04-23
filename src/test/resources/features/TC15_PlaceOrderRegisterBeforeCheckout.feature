@All
Feature: Complete Purchase Flow with Account Creation

  Scenario: End-to-end purchase process with new account
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
    Then I verify Address Details and Review Your Order

    When I enter description in comment text area and click Place Order
    And I enter payment details: Name on Card, Card Number, CVC, Expiration date
    And I click Pay and Confirm Order button
    Then I verify success message Your order has been placed successfully!

    When I click Delete Account button
    Then I verify ACCOUNT DELETED! and click Continue button
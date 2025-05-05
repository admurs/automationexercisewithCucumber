@All
Feature: Product Quantity Verification in Cart

  Scenario: TC13 Verify product quantity in cart
    Given I launch the browser
    When I navigate to url automationexercise
    Then I verify that home page is visible successfully
    When I click View Product for any product on home page
    Then I verify product detail is opened
    When I increase quantity to 4
    And I click Add to cart button
    And I click View Cart button
    Then I verify that product is displayed in cart page with exact quantity
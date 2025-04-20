@All
Feature: Product Cart Management

  Scenario: Add multiple products to cart and verify details
    Given I launch the browser
    When I navigate to url automationexercise
    Then I verify that home page is visible successfully
    When I click on Products button
    And I hover over first product and click Add to cart
    And I click Continue Shopping button
    And I hover over second product and click Add to cart
    And I click View Cart button
    Then I verify both products are added to Cart
    And I verify their prices, quantity and total price
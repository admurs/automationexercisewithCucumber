@All
Feature: Product Removal from Cart

  Scenario: Remove product from shopping cart
    Given I launch the browser
    When I navigate to url automationexercise
    Then I verify that home page is visible successfully
    When I add products to cart
    And I click View Cart button
    Then I verify that cart page is displayed
    When I click X button corresponding to particular product
    Then I verify that product is removed from the cart
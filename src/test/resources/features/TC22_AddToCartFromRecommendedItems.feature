@All
Feature: Recommended Items Cart Functionality

  Scenario: Add recommended product to cart and verify
    Given I launch the browser
    When I navigate to url automationexercise
    And I scroll to bottom of page
    Then I verify RECOMMENDED ITEMS are visible
    When I click on Add To Cart on Recommended product
    And I click on View Cart button
    Then I verify that product is displayed in cart page
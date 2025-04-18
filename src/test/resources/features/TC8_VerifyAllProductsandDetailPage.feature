@All
Feature: Product Details Page Verification

  Scenario: Verify product details page functionality
    Given I launch the browser
    When I navigate to url automationexercise
    Then I verify that home page is visible successfully
    When I click on Products button
    Then I verify user is navigated to ALL PRODUCTS page successfully
    And the products list is visible
    When I click on View Product of first product
    Then I verify user is landed to product detail page
    And I verify that detail is visible: product name, category, price, availability, condition, brand
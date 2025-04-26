@All
Feature: Category Navigation

  Scenario: Verify category and sub-category navigation
    Given I launch the browser
    When I navigate to url automationexercise
    Then I verify that categories are visible on left side bar
    When I click on Women category
    And I click on any category link under Women category, for example: Dress
    Then I verify that category page is displayed and confirm text WOMEN - TOPS PRODUCTS
    When On left side bar, I click on any sub-category link of Men category
    Then I verify that user is navigated to that category page
@All
Feature: Product Search Functionality

  Scenario Outline: TC9 Verify product search functionality
    Given I launch the browser
    When I navigate to url automationexercise
    Then I verify that home page is visible successfully
    When I click on Products button
    Then I verify user is navigated to ALL PRODUCTS page successfully
    When I enter "<product name>" in search input and click search button
    Then I verify SEARCHED PRODUCTS is visible
    And I verify all the products related to search are visible
    Examples:
      | product name |
      |Saree         |
      |T-Shirt       |


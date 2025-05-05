@All
Feature: Brand Navigation Functionality

  Scenario: TC19 Verify brand navigation and product display
    Given I launch the browser
    When I navigate to url automationexercise
    And I click on Products button
    Then I verify that Brands are visible on left side bar
    When I click on any brand name
    Then I verify that user is navigated to brand page and brand products are displayed
    When On left side bar, I click on any other brand link
    Then I verify that user is navigated to that brand page and can see products
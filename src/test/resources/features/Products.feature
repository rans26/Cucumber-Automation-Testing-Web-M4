Feature: Products functionality

  Scenario: Add product to cart
    Given I am logged in with username "standard_user" and password "secret_sauce"
    When I add "Sauce Labs Backpack" to the cart
    Then the cart should contain the added item

  Scenario: View products list
    Given I am logged in with username "standard_user" and password "secret_sauce"
    When I add "Sauce Labs Backpack" to the cart
    Then I should see at least one product in the list
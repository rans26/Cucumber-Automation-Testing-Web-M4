Feature: Checkout Process

  Scenario: Complete checkout process
    Given I am logged in with username "standard_user" and password "secret_sauce"
    When I add "Sauce Labs Backpack" to the cart
    And I proceed to checkout
    And I enter checkout information:
      | First Name | Randi     |
      | Last Name  | Test      |
      | Zip Code   | 999999    |
    And I continue to overview
    Then I should see payment information
    And I should see shipping information
    And I should see item total
    When I finish the checkout
    Then I should see the complete page
    And I should see the confirmation message "Thank you for your order!"
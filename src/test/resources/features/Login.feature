Feature: Login functionality

  @Login_valid
  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be redirected to the products page

  @Login_invalid
  Scenario: Invalid login attempt without password
    Given I am on the login page
    When I enter username "standard_user" and password ""
    And I click the login button
    Then I should see an error message "Epic sadface: Password is required"

  Scenario: Invalid login attempt without password
    Given I am on the login page
    When I enter username "" and password "secret_sauce"
    And I click the login button
    Then I should see an error message "Epic sadface: Username is required"

  Scenario: Failed login with invalid credentials
    Given I am on the login page
    When I enter username "invalid_user" and password "wrong_password"
    And I click the login button
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"
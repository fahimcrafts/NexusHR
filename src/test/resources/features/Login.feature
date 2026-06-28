Feature: Login Functionality

  Scenario: Successful login as Admin
    Given I am on the login page
    When I login with valid admin credentials
    Then I should be redirected to the dashboard
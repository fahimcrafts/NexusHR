Feature: PIM Module Navigation

  Scenario: Admin adds a new employee
    Given I am on the login page
    When I login with valid admin credentials
    And I navigate to PIM module
    And I add a new employee
    Then The employee's details match correctly
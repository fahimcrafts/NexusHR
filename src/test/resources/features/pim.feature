Feature: PIM Module Navigation

  Scenario: User navigates to PIM module
    Given I am on the login page
    When I login with valid admin credentials
    And I navigate to PIM module
    Then The PIM page should be displayed
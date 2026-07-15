Feature: Recruitment candidate management

  Scenario: Admin adds a new candidate
    Given I am on the login page
    When I login with valid admin credentials
    And I navigate to Recruitment module
    And I add a new candidate
    Then The candidate profile should display the correct details
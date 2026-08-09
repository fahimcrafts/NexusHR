Feature: Leave Module Navigation

  Scenario: Admin navigates to Leave module
    Given I am on the login page
    When I login with valid admin credentials
    And I navigate to Leave module
    Then The Leave page should be displayed

    #And I select employee "AutoFN_d8d67 AutoLN_a2823"

  @debug
  Scenario: Admin enters leave entitlement details
    Given I am on the login page
    When I login with valid admin credentials
    And I navigate to Add Entitlements
    And I select employee "AutoFN_d8d67 AutoLN_a2823"
    And I select leave type: "CAN - FMLA"
    And I select leave period: "2026-01-01 - 2026-12-31"
    And I enter entitlement "2.25"


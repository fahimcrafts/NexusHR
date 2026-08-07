Feature: Leave Module Navigation

  Scenario: Admin navigates to Leave module
    Given I am on the login page
    When I login with valid admin credentials
    And I navigate to Leave module
    Then The Leave page should be displayed

    #And I select employee "AutoFN_182d1 AutoLN_73b56"

  @debug
  Scenario: Enter leave entitlement
    Given I am on the login page
    When I login with valid admin credentials
    And I navigate to Add Entitlements
    And I select employee "AutoFN_182d1 AutoLN_73b56"
    And I select leave type: "CAN - FMLA"
    And I enter entitlement "2.25"


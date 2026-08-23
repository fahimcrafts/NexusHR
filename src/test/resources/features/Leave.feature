Feature: Leave Module Navigation

  Scenario: Admin navigates to Leave module
    Given I am on the login page
    When I login with valid admin credentials
    And I navigate to Leave module
    Then The Leave page should be displayed

    #And I select employee "AutoFN_98379 AutoLN_108bb"


  Scenario: Admin enters leave entitlement details
    Given I am on the login page
    When I login with valid admin credentials
    And I navigate to Add Entitlements
    And I select employee "AutoFN_98379 AutoLN_108bb"
    And I select leave type: "CAN - FMLA"
    And I select leave period: "2026-01-01 - 2026-31-12"
    And I enter entitlement "2.25"
    And I click save
    Then The Update Entitlement pop up should be displayed
    And I confirm the entitlement update
    And The entitlement for leave type "CAN - FMLA" should be "2.25"

  @debug
  Scenario: Admin selects leave type on Assign Leave
    Given I am on the login page
    When I login with valid admin credentials
    And I navigate to Assign Leave
    And I select Assign Leave employee "AutoFN_98379 AutoLN_108bb"
    And I select Assign Leave leave type: "CAN - FMLA"
    And I enter Assign Leave from date "2026-08-24"
    Then The Assign Leave from date should be "2026-08-24"
    And I enter Assign Leave to date "2026-08-25"
    Then The Assign Leave to date should be "2026-08-25"

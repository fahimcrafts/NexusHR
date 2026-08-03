Feature: Leave Module Navigation

Scenario: Admin navigates to Leave module
  Given I am on the login page
  When I login with valid admin credentials
  And I navigate to Leave module
  And I select employee "AutoFN_2d619 AutoLN_c442d"
  And I select leave status "Cancelled"
  Then The Leave page should be displayed

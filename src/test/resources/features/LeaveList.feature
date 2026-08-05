Feature: Leave List

Scenario: Admin navigates to Leave module
  Given I am on the login page
  When I login with valid admin credentials
  And I navigate to Leave module
  And I select employee "AutoFN_d770e AutoLN_4a3cc"
  And I select leave status "Cancelled"
  Then The Leave page should be displayed

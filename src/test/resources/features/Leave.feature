Feature: Leave Module Navigation

Scenario: Admin navigates to Leave module
  Given I am on the login page
  When I login with valid admin credentials
  And I navigate to Leave module
  And I select employee "AutoFN_4b40e AutoLN_141c3"
  Then The Leave page should be displayed


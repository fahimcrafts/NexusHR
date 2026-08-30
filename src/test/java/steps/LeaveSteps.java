package steps;

import base.DriverFactory;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import pages.AddEmployeePage;
import pages.AddEntitlementPage;
import pages.AssignLeavePage;
import pages.LeaveListPage;
import pages.LeaveModulePage;
import pages.PersonalDetailsPage;
import pages.PIMPage;

import utils.LoggerUtil;
import utils.DataGenerator;

import org.apache.logging.log4j.Logger;
import static org.testng.Assert.assertTrue;

public class LeaveSteps {
    LeaveListPage leaveListPage = new LeaveListPage(DriverFactory.getDriver());

    Logger logger = LoggerUtil.getLogger(LeaveSteps.class);

    private LeaveModulePage leaveModulePage = new LeaveModulePage(DriverFactory.getDriver());

    private AddEntitlementPage addEntitlementPage = new AddEntitlementPage(DriverFactory.getDriver());

    private AssignLeavePage assignLeavePage = new AssignLeavePage(DriverFactory.getDriver());

    private PIMPage pimPage = new PIMPage(DriverFactory.getDriver());

    private AddEmployeePage addEmployeePage = new AddEmployeePage(DriverFactory.getDriver());

    private PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage(DriverFactory.getDriver());

    private String leaveEmployeeName;

    @When("I create a new employee for the leave workflow")
    public void createEmployeeForLeaveWorkflow(){
        String firstName = DataGenerator.getFirstName();
        String lastName = DataGenerator.getLastName();
        String employeeId = DataGenerator.getEmployeeId();

        leaveEmployeeName = firstName + " " + lastName;

        logger.info("Generated Leave employee: {} {} | ID: {}", firstName, lastName, employeeId);

        pimPage.navigateToPIM();
        addEmployeePage.addEmployee(firstName, lastName, employeeId);

        assertTrue(addEmployeePage.isPersonalDetailsPageDisplayed(), "Employee was not created for Leave workflow");
    }

    @When("I navigate to Leave module")
    public void navigateToLeaveModule(){
        leaveListPage.navigateToLeave();
    }

    @When("I select in Leave List employee {string}")
    public void selectLeaveListEmployee(String employeeName){
        leaveListPage.selectEmployee(employeeName);
    }

    @When("I select employee {string}")
    public void selectAddEntitlementEmployee(String employeeName){
        addEntitlementPage.selectEmployee(employeeName);
    }

    @When("I select Assign Leave employee {string}")
    public void iSelectAssignLeaveEmployee(String employeeName){
        assignLeavePage.selectEmployee(employeeName);
    }

    @When("I select leave status {string}")
    public void selectLeaveStatus(String status){
        leaveListPage.selectLeaveStatus(status);
    }

    @Then("The Leave page should be displayed")
    public void verifyLeavePage(){
        assertTrue(leaveListPage.isLeavePageDisplayed());
    }

    @When("I navigate to Add Entitlements")
    public void iNavigateToAddEntitlements() {
        leaveModulePage.navigateToLeave();
        leaveModulePage.openAddEntitlements();
    }

    @When("I navigate to Assign Leave")
    public void iNavigateToAssignLeave() {
        leaveModulePage.navigateToLeave();
        leaveModulePage.openAssignLeaveMenu();
    }

    @Then("The Add Entitlement page should be displayed")
    public void theAddEntitlementPageShouldBeDisplayed() {
        assertTrue(addEntitlementPage.isAddEntitlementPageDisplayed());
    }

    @When("I select leave type: {string}")
    public void iSelectLeaveType(String leaveType){
        addEntitlementPage.selectLeaveType(leaveType);
    }

    @When("I select Assign Leave leave type: {string}")
    public void iSelectAssignLeaveLeaveType(String leaveType){
        assignLeavePage.selectLeaveType(leaveType);
    }

    @When("I select leave period: {string}")
    public void iSelectLeavePeriod(String leavePeriod){
        addEntitlementPage.selectLeavePeriod(leavePeriod);
    }

    @When("I enter entitlement {string}")
    public void iEnterEntitlement(String entitlement){
        addEntitlementPage.enterEntitlement(entitlement);
    }

    @When("I click save")
    public void iClickSave(){
        addEntitlementPage.clickSave();
    }

    @Then("The Update Entitlement pop up should be displayed")
    public void theUpdateEntitlementPopUpShouldBeDisplayed() {
        addEntitlementPage.updatingEntitlementPopUpIsDisplayed();
    }

    @When("I confirm the entitlement update")
    public void iConfirmTheEntitlementUpdate() {
        addEntitlementPage.clickConfirmEntitlementButton();
    }

    @When("The entitlement for leave type {string} should be {string}"
    )
    public void theEntitlementShouldBe(String leaveType, String expectedEntitlement) {
       assertTrue(addEntitlementPage.isEntitlementDisplayed(leaveType, expectedEntitlement));
    }


    @When("I enter Assign Leave from date {string}")
    public void iEnterAssignLeaveFromDate(String date) {
        assignLeavePage.enterFromDate(date);
    }

    @Then("The Assign Leave from date should be {string}")
    public void theAssignLeaveFromDateShouldBe(String expectedDate) {
        assertTrue(assignLeavePage.isFromDateDisplayed(expectedDate));
    }

    @When("I enter Assign Leave to date {string}")
    public void iEnterAssignLeaveToDate(String date) {
        assignLeavePage.enterToDate(date);
    }

    @Then("The Assign Leave to date should be {string}")
    public void theAssignLeaveToDateShouldBe(String date) {
        assertTrue(assignLeavePage.isToDateDisplayed(date));
    }

    @When("I click in Assign Leave assign button")
    public void iClickAssignButton() {
        assignLeavePage.clickAssign();
    }

    @When("I click in Leave List search button")
    public void iClickSearchButton() {
        leaveListPage.clickSearch();
    }

    @Then("The leave record should show employee {string}, leave type {string}, from {string}, to {string}, and status {string}")
    public void theLeaveRecordShouldBeDisplayed(String employeeName, String leaveType, String fromDate, String toDate, String status){
        assertTrue(leaveListPage.isLeaveRecordDisplayed(employeeName, leaveType, fromDate, toDate, status));
    }

    @When("I select employee for the leave workflow")
    public void iSelectEmployeeForTheLeaveWorkflow() {
       addEntitlementPage.selectEmployee(leaveEmployeeName);
    }

    @When("I select Assign Leave employee for the leave workflow")
    public void iSelectAssignLeaveEmployeeForTheLeaveWorkflow() {
        assignLeavePage.selectEmployee(leaveEmployeeName);
    }

    @When("I select in Leave List employee for the leave workflow")
    public void iSelectInLeaveListEmployeeForTheLeaveWorkflow() {
        leaveListPage.selectEmployee(leaveEmployeeName);
    }

    @Then("The leave record should show employee for the leave workflow, leave type {string}, from {string}, to {string}, and status {string}")
    public void theLeaveRecordShouldShowEmployeeForTheLeaveWorkflowLeaveTypeFromToAndStatus(
            String leaveType, String fromDate, String toDate, String status) {
        assertTrue(
                leaveListPage.isLeaveRecordDisplayed(
                        leaveEmployeeName,
                        leaveType,
                        fromDate,
                        toDate,
                        status
                ),
                "Leave record was not found for employee: " + leaveEmployeeName
        );
    }
}

package steps;

import base.DriverFactory;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.AddEntitlementPage;
import pages.LeaveListPage;
import pages.LeaveModulePage;
import pages.AssignLeavePage;
import utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import static org.testng.Assert.assertTrue;

public class LeaveSteps {
    LeaveListPage leaveListPage = new LeaveListPage(DriverFactory.getDriver());

    Logger logger = LoggerUtil.getLogger(LeaveSteps.class);

    private LeaveModulePage leaveModulePage = new LeaveModulePage(DriverFactory.getDriver());

    private AddEntitlementPage addEntitlementPage = new AddEntitlementPage(DriverFactory.getDriver());

    private AssignLeavePage assignLeavePage = new AssignLeavePage(DriverFactory.getDriver());

    @When("I navigate to Leave module")
    public void navigateToLeaveModule(){
        leaveListPage.navigateToLeave();
    }

    @When("I select employee {string}")
    public void selectEmployee(String employeeName){
        addEntitlementPage.selectEmployee(employeeName);
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

    @And("I confirm the entitlement update")
    public void iConfirmTheEntitlementUpdate() {
        addEntitlementPage.clickConfirmEntitlementButton();
    }

    @And("The entitlement for leave type {string} should be {string}"
    )
    public void theEntitlementShouldBe(String leaveType, String expectedEntitlement) {
       assertTrue(addEntitlementPage.isEntitlementDisplayed(leaveType, expectedEntitlement));
    }
}

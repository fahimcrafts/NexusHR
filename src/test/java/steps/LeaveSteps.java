package steps;

import base.DriverFactory;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.AddEntitlementPage;
import pages.LeaveListPage;
import pages.LeaveModulePage;
import utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import static org.testng.Assert.assertTrue;

public class LeaveSteps {
    LeaveListPage leaveListPage = new LeaveListPage(DriverFactory.getDriver());

    Logger logger = LoggerUtil.getLogger(LeaveSteps.class);

    private LeaveModulePage leaveModulePage = new LeaveModulePage(DriverFactory.getDriver());

    private AddEntitlementPage addEntitlementPage = new AddEntitlementPage(DriverFactory.getDriver());

    @When("I navigate to Leave module")
    public void navigateToLeaveModule(){
        leaveListPage.navigateToLeave();
    }

    @When("I select employee {string}")
    public void selectEmployee(String employeeName){
        leaveListPage.selectEmployee(employeeName);
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

    @Then("The Add Entitlement page should be displayed")
    public void theAddEntitlementPageShouldBeDisplayed() {
        assertTrue(addEntitlementPage.isAddEntitlementPageDisplayed());
    }
}

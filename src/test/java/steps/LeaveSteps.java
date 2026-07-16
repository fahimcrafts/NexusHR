package steps;

import base.DriverFactory;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LeavePage;
import utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import static org.testng.Assert.assertTrue;

public class LeaveSteps {
    LeavePage leavePage = new LeavePage(DriverFactory.getDriver());

    Logger logger = LoggerUtil.getLogger(LeaveSteps.class);

    @When("I navigate to Leave module")
    public void navigateToLeaveModule(){
        leavePage.navigateToLeave();
    }

    @Then("The Leave page should be displayed")
    public void verifyLeavePage(){
        assertTrue(leavePage.isLeavePageDisplayed());
    }
}

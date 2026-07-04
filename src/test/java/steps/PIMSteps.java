package steps;

import base.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PIMPage;

import static org.testng.Assert.assertTrue;

public class PIMSteps {

    PIMPage pimPage = new PIMPage(DriverFactory.getDriver());

    @When("I navigate to PIM module")
    public void navigateToPIMModule() {
        pimPage.navigateToPIM();
    }

    @Then("The PIM page should be displayed")
    public void verifyPIMPage() {
        assertTrue(pimPage.isPIMPageDisplayed(),
                "PIM page was not displayed");
    }
}
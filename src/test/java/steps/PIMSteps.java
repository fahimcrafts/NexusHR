package steps;

import base.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePage;
import pages.PIMPage;
import utils.DataGenerator;
import utils.LoggerUtil;
import org.apache.logging.log4j.Logger;

import static org.testng.Assert.assertTrue;

public class PIMSteps {

    PIMPage pimPage = new PIMPage(DriverFactory.getDriver());
    AddEmployeePage addEmployeePage = new AddEmployeePage(DriverFactory.getDriver());

    Logger logger = LoggerUtil.getLogger(PIMSteps.class);

    @When("I navigate to PIM module")
    public void navigateToPIMModule() {
        pimPage.navigateToPIM();
    }

    @Then("The PIM page should be displayed")
    public void verifyPIMPage() {
        assertTrue(pimPage.isPIMPageDisplayed(),
                "PIM page was not displayed");
    }

    @When("I add a new employee")
    public void addNewEmployee() {
        String firstName = DataGenerator.getFirstName();
        String lastName = DataGenerator.getLastName();

        logger.info("Generated Employee: {} {}", firstName, lastName);

        addEmployeePage.addEmployee(firstName, lastName);
    }

    @Then("The employee should be added successfully")
    public void verifyEmployeeAdded(){
        assertTrue(addEmployeePage.isPersonalDetailsPageDisplayed(), "Employee details page was not displayed");
    }
}
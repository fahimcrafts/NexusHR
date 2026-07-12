package steps;

import base.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePage;
import pages.PIMPage;
import pages.PersonalDetailsPage;
import utils.DataGenerator;
import utils.LoggerUtil;
import org.apache.logging.log4j.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PIMSteps {

    PIMPage pimPage = new PIMPage(DriverFactory.getDriver());
    AddEmployeePage addEmployeePage = new AddEmployeePage(DriverFactory.getDriver());
    PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage(DriverFactory.getDriver());

    Logger logger = LoggerUtil.getLogger(PIMSteps.class);

    private String firstName;
    private String lastName;
    private String employeeId;

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
        firstName = DataGenerator.getFirstName();
        lastName = DataGenerator.getLastName();
        employeeId = DataGenerator.getEmployeeId();

        logger.info("Generated Employee: {} {}, ID: {}", firstName, lastName, employeeId);

        addEmployeePage.addEmployee(firstName, lastName, employeeId);
    }

    /*@Then("The employee should be added successfully")
    public void verifyEmployeeAdded(){
        assertTrue(addEmployeePage.isPersonalDetailsPageDisplayed(), "Employee details page was not displayed");
    }*/

    @Then("The employee's details match correctly")
    public void verifyEmployeeMatch(){
        assertEquals(personalDetailsPage.getFirstName(), firstName, "First name does not match");

        assertEquals(personalDetailsPage.getLastName(), lastName, "Last name does not match");

        assertTrue(personalDetailsPage.getEmployeeId().contains(employeeId),"Employee ID does not match");
    }
}
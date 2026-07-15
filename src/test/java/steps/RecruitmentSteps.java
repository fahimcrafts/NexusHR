package steps;

import base.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import pages.RecruitmentPage;
import pages.RecruitmentAddCandidatePage;
import pages.CandidateProfilePage;
import utils.DataGenerator;
import utils.LoggerUtil;
import static org.testng.Assert.assertEquals;

public class RecruitmentSteps {
    RecruitmentPage recruitmentPage = new RecruitmentPage(DriverFactory.getDriver());
    RecruitmentAddCandidatePage recruitmentAddCandidatePage = new RecruitmentAddCandidatePage(DriverFactory.getDriver());
    CandidateProfilePage candidateProfilePage = new CandidateProfilePage(DriverFactory.getDriver());

    Logger logger = LoggerUtil.getLogger(RecruitmentSteps.class);

    private String firstName;
    private String lastName;
    private String email;

    @When("I navigate to Recruitment module")
    public void navigateToRecruitmentModule(){
        recruitmentPage.navigateToRecruitment();
        recruitmentPage.clickAddButton();
    }

    @When("I add a new candidate")
    public void addNewCandidate() {
        firstName = DataGenerator.getFirstName();
        lastName = DataGenerator.getLastName();
        email = DataGenerator.getEmail();

        logger.info("Generated Candidate: {} {}, Email: {}", firstName, lastName, email);

        recruitmentAddCandidatePage.addCandidate(firstName, lastName, email);
    }

    @Then("The candidate profile should display the correct details")
    public void verifyCandidateProfileDetails(){
        assertEquals(candidateProfilePage.getFirstName(), firstName, "First name does not match");

        assertEquals(candidateProfilePage.getLastName(), lastName, "Last name does not match");

        assertEquals(candidateProfilePage.getEmail(), email, "Email does not match");
    }
}

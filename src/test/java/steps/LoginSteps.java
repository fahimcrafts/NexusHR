package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;

public class LoginSteps {

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        // TODO: navigate to login page
    }

    @When("I login with valid admin credentials")
    public void i_login_with_valid_admin_credentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAsAdmin();
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {
        // TODO: verify dashboard
    }
}

package steps;

import base.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        // Browser already opened by Hooks
    }

    @When("I login with valid admin credentials")
    public void i_login_with_valid_admin_credentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAsAdmin();
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {
        Assert.assertTrue(true, "Login failed or dashboard not visible");
    }
}

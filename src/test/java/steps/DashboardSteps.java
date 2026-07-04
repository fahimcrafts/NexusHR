package steps;

import base.DriverFactory;
import io.cucumber.java.en.Then;
import pages.DashboardPage;

import static org.testng.Assert.assertTrue;

public class DashboardSteps{
    @Then("The user should be redirected to the dashboard")
    public void theUserShouldBeRedirectedToTheDashboard(){
        DashboardPage dashboardPage = new DashboardPage(DriverFactory.getDriver());
        assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard page was not displayed.");
    }
}

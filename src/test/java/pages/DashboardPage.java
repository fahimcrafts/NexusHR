package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    private final By dashboardHeader = By.xpath("//h6[normalize-space()='Dashboard']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardDisplayed() {
        return isDisplayed(dashboardHeader);
    }
}
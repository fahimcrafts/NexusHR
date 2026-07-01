package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    private final WebDriver driver;

    private final By dashboardHeader = By.xpath("//h6[normalize-space()='Dashboard']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardDisplayed() {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).isDisplayed();
    }
}
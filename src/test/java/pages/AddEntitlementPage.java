package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEntitlementPage extends BasePage {
    private final By addEntitlementTitle = By.xpath("//p[normalize-space()='Add Leave Entitlement']");

    public AddEntitlementPage(WebDriver driver){
        super(driver);
    }

    public boolean isAddEntitlementPageDisplayed() {
        return isDisplayed(addEntitlementTitle);
    }
}

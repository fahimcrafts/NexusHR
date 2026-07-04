package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage extends BasePage {

    private final By pimMenu = By.cssSelector("a[href='/web/index.php/pim/viewPimModule']");
    private final By pimHeader = By.xpath("//h6[normalize-space()='PIM']");

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToPIM() {
        click(pimMenu);
    }

    public boolean isPIMPageDisplayed() {
        return isDisplayed(pimHeader);
    }
}
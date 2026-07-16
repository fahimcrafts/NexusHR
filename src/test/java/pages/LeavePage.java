package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeavePage extends BasePage {
    private final By leaveMenu = By.cssSelector("a[href='/web/index.php/leave/viewLeaveModule']");

    private final By leaveHeader = By.xpath("//h6[normalize-space()='Leave']");

    public LeavePage(WebDriver driver){
        super(driver);
    }

    public void navigateToLeave(){
        click(leaveMenu);
    }

    public boolean isLeavePageDisplayed(){
        return isDisplayed(leaveHeader);
    }

}

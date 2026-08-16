package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeaveModulePage extends BasePage {
    private final By leaveMenu = By.cssSelector("a[href='/web/index.php/leave/viewLeaveModule']");
    private final By entitlementsDropdown = By.xpath("//span[normalize-space()='Entitlements']");
    private final By addEntitlementOption = By.xpath("//a[normalize-space()='Add Entitlements']");
    private final By assignLeaveMenu = By.xpath("//a[normalize-space()='Assign Leave']");

    public LeaveModulePage(WebDriver driver){
        super(driver);
    }

    public void navigateToLeave(){
        click(leaveMenu);
    }

    public void openAddEntitlements(){
        click(entitlementsDropdown);
        click(addEntitlementOption);
    }

    public void openAssignLeaveMenu(){
        click(assignLeaveMenu);
    }
}

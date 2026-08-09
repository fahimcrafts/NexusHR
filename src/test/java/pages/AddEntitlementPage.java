package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AddEntitlementPage extends BasePage {
    private final By addEntitlementTitle = By.xpath("//p[normalize-space()='Add Leave Entitlement']");
    private final By employeeNameInput = By.xpath("//label[normalize-space()='Employee Name']/ancestor::div[contains(@class,'oxd-input')]//input");
    private final By entitlementInput = By.xpath("//label[normalize-space()='Entitlement']/ancestor::div[contains(@class,'oxd-input')]//input");

    private final By searchingIndicator = By.xpath("//div[text()='Searching...' or text()='Searching...']");

    private final By autocompleteList = By.cssSelector("[role='listbox']");

    private final By autocompleteOptions = By.cssSelector(".oxd-autocomplete-dropdown div[role='option']");

    private final By leaveTypeDropdown = By.cssSelector(".oxd-select-text");

    private final By leaveTypeOptions = By.cssSelector(".oxd-select-option[role='option']");

    private final By leavePeriodDropdown = By.xpath("//label[normalize-space()='Leave Period']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");

    private final By leavePeriodOptions = By.cssSelector(".oxd-select-option[role='option']");

    public AddEntitlementPage(WebDriver driver){
        super(driver);
    }

    public boolean isAddEntitlementPageDisplayed() {
        return isDisplayed(addEntitlementTitle);
    }

    public void selectEmployee(String employeeName){
        type(employeeNameInput, employeeName);

        waitForInvisibility(searchingIndicator);
        waitForVisibility(autocompleteList);

        for(WebElement option : driver.findElements(autocompleteOptions)){
            if(option.getText().equals(employeeName)){
                Actions actions = new Actions(driver);
                actions.moveToElement(option)
                        .click()
                        .perform();
                break;
            }
        }

        waitForVisibility(employeeNameInput);

        String actualEmployeeName = getAttributeValue(employeeNameInput).trim().replaceAll("\\s+", " ");

        if(!actualEmployeeName.equals(employeeName)){
            throw new IllegalStateException("Failed to select employee: " + employeeName);
        }
    }

    public void selectLeaveType(String leaveType){
        click(leaveTypeDropdown);

        waitForVisibility(leaveTypeOptions);

        boolean typeFound = false;

        for(WebElement option : driver.findElements(leaveTypeOptions)){
            if(option.getText().equals(leaveType)){
                Actions actions = new Actions(driver);
                actions.moveToElement(option)
                        .click()
                        .perform();

                typeFound = true;
                break;
            }
        }

        if(!typeFound){
            throw new IllegalArgumentException("Leave type not found: " + leaveType);
        }
    }

    public void selectLeavePeriod(String leavePeriod){
        click(leavePeriodDropdown);

        boolean periodFound = false;

        for(WebElement option : driver.findElements(leavePeriodOptions)){
            if(option.getText().equals(leavePeriod)){
                Actions actions = new Actions(driver);
                actions.moveToElement(option)
                        .click()
                        .perform();

                periodFound = true;
                break;
            }
        }

        if(!periodFound){
            throw new IllegalArgumentException("Leave period not found: " + leavePeriod);
        }
    }

    public void enterEntitlement(String entitlement){
        type(entitlementInput, entitlement);
    }
}

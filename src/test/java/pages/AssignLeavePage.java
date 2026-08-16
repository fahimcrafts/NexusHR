package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AssignLeavePage extends BasePage{
    private final By assignLeaveTitle = By.xpath("//h6[normalize-space()='Assign Leave']");
    private final By employeeNameInput = By.xpath("//label[normalize-space()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By autocompleteOptions = By.cssSelector(".oxd-autocomplete-dropdown div[role='option']");
    private final By leaveTypeDropdown = By.xpath("//label[normalize-space()='Leave Type']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-wrapper')]");
    private final By leaveTypeOptions = By.cssSelector(".oxd-select-option[role='option']");
    private final By fromDate = By.xpath("//label[normalize-space()='From Date']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By toDate = By.xpath("//label[normalize-space()='To Date']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By assignButton = By.cssSelector("button[type='submit']");


    public AssignLeavePage(WebDriver driver){
        super(driver);
    }

    public boolean isAssignLeavePageDisplayed(){
        return isDisplayed(assignLeaveTitle);
    }

    public void selectEmployee(String employeeName){
        type(employeeNameInput, employeeName);

        wait.until(ExpectedConditions.textToBePresentInElementLocated(autocompleteOptions, employeeName));

        for(WebElement option : driver.findElements(autocompleteOptions)){
            if(option.getText().equals(employeeName)){
                option.click();

                wait.until(driver -> {
                    String actual = getAttributeValue(employeeNameInput);
                    return actual != null
                            && actual.trim().replaceAll("\\s+", " ").equals(employeeName);
                });
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
}

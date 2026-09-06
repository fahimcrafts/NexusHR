package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

    private final By successToast = By.cssSelector("p.oxd-toast-content-text");

    public AssignLeavePage(WebDriver driver){
        super(driver);
    }

    public boolean isAssignLeavePageDisplayed(){
        return isDisplayed(assignLeaveTitle);
    }

    public void selectEmployee(String employeeName){
        type(employeeNameInput, employeeName);

        waitForText(autocompleteOptions, employeeName);

        for(WebElement option : driver.findElements(autocompleteOptions)){
            if(option.getText().equals(employeeName)){
                option.click();

                waitForInputValue(employeeNameInput, employeeName);
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

        List<WebElement> options = driver.findElements(leaveTypeOptions);

        boolean typeFound = false;

        for(WebElement option : options){
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

    public void enterFromDate(String date){
        type(fromDate, date);
    }

    public boolean isFromDateDisplayed(String expectedDate){
        String actualDate = getAttributeValue(fromDate);
        return actualDate != null && actualDate.equals(expectedDate);
    }

    public void enterToDate(String date){
        WebElement elem = waitForVisibility(toDate);
        elem.click();
        elem.sendKeys(Keys.CONTROL, "a");
        elem.sendKeys(date);
    }

    public boolean isToDateDisplayed(String expectedDate){
        String actualDate = getAttributeValue(toDate);
        return actualDate != null && actualDate.equals(expectedDate);
    }

    public void clickAssign(){
        click(assignButton);
        waitForVisibility(successToast);
    }
}

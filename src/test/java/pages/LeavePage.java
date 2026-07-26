package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LeavePage extends BasePage {
    private final By leaveMenu = By.cssSelector("a[href='/web/index.php/leave/viewLeaveModule']");

    private final By leaveHeader = By.xpath("//h6[normalize-space()='Leave']");

    private final By employeeNameInput = By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input");

    private final By searchingIndicator =
            By.xpath("//div[text()='Searching....' or text()='Searching...']");

    private final By autocompleteOptions =
            By.cssSelector(".oxd-autocomplete-dropdown div[role='option']");

    private final By autocompleteList = By.cssSelector("[role='listbox']");

    private By employeeOption(String employeeName){
        return By.xpath("//div[@role='option'][contains(.,'" + employeeName + "')]");
    }

    public LeavePage(WebDriver driver){
        super(driver);
    }

    public void navigateToLeave(){
        click(leaveMenu);
    }

    public boolean isLeavePageDisplayed(){
        return isDisplayed(leaveHeader);
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

        if(!getAttributeValue(employeeNameInput).equals(employeeName)){
            throw new IllegalStateException("Failed to select employee: " + employeeName);
        }
    }

}

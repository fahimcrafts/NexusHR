package pages;

import base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeaveListPage extends BasePage {
    private final By leaveMenu = By.cssSelector("a[href='/web/index.php/leave/viewLeaveModule']");

    private final By leaveHeader = By.xpath("//h6[normalize-space()='Leave']");

    private final By employeeNameInput = By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input");

    private final By searchingIndicator =
            By.xpath("//div[text()='Searching....' or text()='Searching...']");

    private final By autocompleteOptions =
            By.cssSelector(".oxd-autocomplete-dropdown div[role='option']");

    private final By autocompleteList = By.cssSelector("[role='listbox']");

    private final By leaveStatusDropdown = By.cssSelector(".oxd-select-text");

    private final By leaveStatusOptions = By.cssSelector(".oxd-select-option");

    private final By selectedLeaveStatusChips = By.cssSelector(".oxd-multiselect-chips-selected");

    private final By searchButton = By.cssSelector("button[type='submit']");

    public LeaveListPage(WebDriver driver){
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

        String actualEmployeeName = getAttributeValue(employeeNameInput).trim().replaceAll("\\s+"," ");

        if(!actualEmployeeName.equals(employeeName)){
            throw new IllegalStateException("Failed to select employee: " + employeeName);
        }
    }

    public void selectLeaveStatus(String status) {
        click(leaveStatusDropdown);

        waitForVisibility(leaveStatusOptions);

        boolean statusFound = false;

        for(WebElement option: driver.findElements(leaveStatusOptions)){
            if(option.getText().equals(status)){
                Actions actions = new Actions(driver);
                actions.moveToElement(option)
                        .click()
                        .perform();

                statusFound = true;
                break;
            }
        }

        if(!statusFound){
            throw new IllegalArgumentException("Leave status not found: " + status);
        }
    }

    public void clickSearch(){
        click(searchButton);
        waitForVisibility(searchingIndicator);
    }

    public boolean isLeaveRecordDisplayed(String employeeName, String leaveType, String fromDate, String toDate, String status) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter uiFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String expectedDate = LocalDate.parse(fromDate, inputFormatter).format(uiFormatter) +
                " to " +
                LocalDate.parse(toDate, inputFormatter).format(uiFormatter);

        By leaveRecord = By.xpath("//div[@role='row']" +
                "[.//div[normalize-space()='" + employeeName + "']]" +
                "[.//div[normalize-space()='" + leaveType + "']]" +
                "[.//div[normalize-space()='" + expectedDate + "']]" +
                "[.//div[contains(normalize-space(),'" + status + "')]]"
        );

        System.out.println("Leave page URL: " + driver.getCurrentUrl());
        System.out.println("Leave page text:");
        System.out.println(driver.findElement(By.tagName("body")).getText());

        return isDisplayed(leaveRecord);

    }
}

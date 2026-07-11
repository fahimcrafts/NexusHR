package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage extends BasePage {
    private final By addEmployeeButton =
            By.xpath("//a[normalize-space()='Add Employee']");

    private final By firstNameInput =
            By.name("firstName");

    private final By lastNameInput =
            By.name("lastName");

    private final By employeeIdInput = By.xpath("//label[text()='Employee Id']/../..//input");

    private final By saveButton =
            By.cssSelector("button[type='submit']");

    private final By personalDetailsHeader =
            By.xpath("//a[normalize-space()='Personal Details']");

    public AddEmployeePage(WebDriver driver) {
        super(driver);
    }

    public void clickAddEmployee() {
        click(addEmployeeButton);
    }

    public void enterFirstName(String firstName) {
        type(firstNameInput, firstName);
    }

    public void enterLastName(String lastName) {
        type(lastNameInput, lastName);
    }

    public void enterEmployeeId(String employeeId){
        type(employeeIdInput, employeeId);
    }

    public void clickSave() {
        click(saveButton);
    }

    public void addEmployee(String firstName, String lastName, String employeeId){
        clickAddEmployee();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmployeeId(employeeId);
        clickSave();
    }

    public boolean isPersonalDetailsPageDisplayed() {
        return isDisplayed(personalDetailsHeader);
    }
}
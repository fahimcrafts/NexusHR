package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage extends BasePage {
    private final By addEmployeeButton =
            By.xpath("//a[text()='Add Employee']");

    private final By firstNameInput =
            By.name("firstName");

    private final By lastNameInput =
            By.name("lastName");

    private final By saveButton =
            By.cssSelector("button[type='submit']");

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

    public void clickSave() {
        click(saveButton);
    }

    public void addEmployee(String firstName, String lastName){
        clickAddEmployee();
        enterFirstName(firstName);
        enterLastName(lastName);
        clickSave();
    }
}
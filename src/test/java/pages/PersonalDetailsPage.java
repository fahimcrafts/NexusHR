package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalDetailsPage extends BasePage{
    private final By firstNameInput =
            By.name("firstName");

    private final By lastNameInput =
            By.name("lastName");

    private final By employeeIdInput = By.xpath("//label[normalize-space()='Employee Id']/../..//input");

    public PersonalDetailsPage(WebDriver driver){
        super(driver);
    }

    public String getFirstName() {
        return getAttributeValue(firstNameInput);
    }

    public String getLastName() {
        return getAttributeValue(lastNameInput);
    }

    public String getEmployeeId() {
        return getAttributeValue(employeeIdInput);
    }
}

package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruitmentAddCandidatePage extends BasePage {
    private final By firstNameInput = By.name("firstname");
    private final By lastNameInput = By.name("lastname");
    private final By emailInput = By.xpath("//label[normalize-space()='Email']/following::input[1]");

    private final By saveButton = By.cssSelector("button[type = 'submit']");


    public RecruitmentAddCandidatePage(WebDriver driver){
        super(driver);
    }

    public void enterFirstName(String firstName){
        type(firstNameInput, firstName);
    }

    public void enterLastName(String lastName){
        type(lastNameInput, lastName);
    }

    public void enterEmail(String email){
        type(emailInput, email);
    }

    public void clickSave(){
        click(saveButton);
    }

    public void addCandidate(String firstName, String lastName, String email){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        clickSave();
    }

}

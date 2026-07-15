package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CandidateProfilePage extends BasePage{
    private final By candidateProfileHeader = By.xpath("//h6[normalize-space()='Candidate Profile']");

    private final By firstNameInput = By.name("firstname");
    private final By lastNameInput = By.name("lastname");
    private final By emailInput = By.xpath("//label[normalize-space()='Email']/following::input[1]");

    public CandidateProfilePage(WebDriver driver){
        super(driver);
    }

    public boolean isCandidateProfilePageDisplayed(){
        return isDisplayed(candidateProfileHeader);
    }

    public String getFirstName() {
        return getAttributeValue(firstNameInput);
    }

    public String getLastName() {
        return getAttributeValue(lastNameInput);
    }

    public String getEmail() {
        return getAttributeValue(emailInput);
    }


}

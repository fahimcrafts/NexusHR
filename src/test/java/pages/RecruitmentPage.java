package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruitmentPage extends BasePage{
    private final By recruitmentMenu = By.cssSelector("a[href='/web/index.php/recruitment/viewRecruitmentModule']");

    private final By addButton = By.xpath("//button[normalize-space()='Add']");

    public RecruitmentPage(WebDriver driver){
        super(driver);
    }

    public void navigateToRecruitment(){
        click(recruitmentMenu);
    }

    public void clickAddButton(){
        click(addButton);
    }
}

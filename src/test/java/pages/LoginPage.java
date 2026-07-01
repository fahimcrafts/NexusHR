package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }

    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.cssSelector("button[type='submit']");

    public void loginAsAdmin(){
        login("Admin", "admin123");
    }

    public void login(String user, String pass){
        type(username, user);
        type(password, pass);
        click(loginBtn);
    }
}

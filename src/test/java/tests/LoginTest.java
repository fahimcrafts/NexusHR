package tests;

import base.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginTest {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.initDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        driver.quit();
    }
}

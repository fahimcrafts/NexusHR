package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(groups = "smoke")
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAsAdmin();

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

}

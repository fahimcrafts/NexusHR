package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected WebElement waitForVisibility(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}

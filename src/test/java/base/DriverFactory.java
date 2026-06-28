package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

public class DriverFactory {

    private static WebDriver driver;
    private static final ConfigReader configReader = new ConfigReader();

    public static WebDriver initDriver(){
        String browser = configReader.getBrowser();

        switch(browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser
                );
        }

        driver.manage().window().maximize();

        return driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }
}

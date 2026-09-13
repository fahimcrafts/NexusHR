package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.ConfigReader;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final ConfigReader configReader = new ConfigReader();

    public static WebDriver initDriver(){
        String browser = configReader.getBrowser();

        if(driver.get() != null){
            driver.get().quit();
            driver.remove();
        }

        switch(browser.toLowerCase()) {
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.addArguments("--headless=new");
                cOptions.addArguments("--window-size=1920,1080");

                driver.set(new ChromeDriver(cOptions));
                break;

            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.addArguments("--headless=new");
                fOptions.addArguments("--window-size=1920,1080");

                driver.set(new FirefoxDriver(fOptions));
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser
                );
        }

        return driver.get();
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        if(driver.get() != null){
            driver.get().quit();
            driver.remove();
        }
    }
}

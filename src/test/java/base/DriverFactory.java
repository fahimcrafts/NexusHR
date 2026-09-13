package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                driver.set(new FirefoxDriver());
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser
                );
        }

        driver.get().manage().window().setSize(new Dimension(1920, 1080));

        System.out.println("Jenkins Browser Window: "
        + driver.get().manage().window().getSize());
        System.out.println("Jenkins Viewport: "
                + ((JavascriptExecutor) driver.get())
                .executeScript("return window.innerWidth + 'x' + window.innerHeight;"
                ));

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

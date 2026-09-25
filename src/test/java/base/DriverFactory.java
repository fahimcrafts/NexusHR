package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final ConfigReader configReader = new ConfigReader();

    public static WebDriver initDriver(){
        String browser = configReader.getBrowser();
        String execution = configReader.getExecution();

        if(driver.get() != null){
            driver.get().quit();
            driver.remove();
        }

        switch(browser.toLowerCase()) {
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.addArguments("--headless=new");
                cOptions.addArguments("--window-size=1920,1080");

                if(execution.equalsIgnoreCase("remote")){
                    driver.set(createRemoteDriver(cOptions));
                }
                else {
                    driver.set(new ChromeDriver(cOptions));
                }
                break;

            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.addArguments("--headless=new");
                fOptions.addArguments("--window-size=1920,1080");

                if(execution.equalsIgnoreCase("remote")){
                    driver.set(createRemoteDriver(fOptions));
                }
                else {
                    driver.set(new FirefoxDriver(fOptions));
                }
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser
                );
        }

        return driver.get();
    }

    private static WebDriver createRemoteDriver(org.openqa.selenium.MutableCapabilities options){
        try{
            return new RemoteWebDriver(
                    URI.create(configReader.getRemoteUrl()).toURL(), options
            );
        }
        catch (MalformedURLException e){
            throw new RuntimeException("Invalid remote WebDriver URL", e);
        }
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

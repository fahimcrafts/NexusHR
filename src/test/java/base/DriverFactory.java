package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver initDriver(){
        ConfigReader configReader = new ConfigReader();
        String browser = configReader.getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.get(configReader.getUrl());

        return driver;
    }
}

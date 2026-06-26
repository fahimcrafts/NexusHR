package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver initDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        ConfigReader configReader = new ConfigReader();
        driver.get(configReader.getUrl());

        return driver;
    }
}

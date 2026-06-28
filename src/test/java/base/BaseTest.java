package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {

    protected WebDriver driver;
    protected Logger logger = LogManager.getLogger(this.getClass());
    private ConfigReader configReader = new ConfigReader();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = DriverFactory.initDriver();

        logger.info("Driver initialized successfully");

        driver.get(configReader.getUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if(driver != null){
            driver.quit();
        }
    }
}
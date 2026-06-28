package hooks;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.LoggerUtil;
import org.apache.logging.log4j.Logger;

public class Hooks {

    private static final Logger logger = LoggerUtil.getLogger(Hooks.class);

    @Before
    public void setUp() {
        DriverFactory.initDriver();
        DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");

        logger.info("Browser launched and application opened");
    }

    @After
    public void tearDown() {
        logger.info("Closing browser session");

        //DriverFactory.getDriver().quit();
    }
}
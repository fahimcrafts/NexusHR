package hooks;

import base.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import java.util.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    private static final Logger logger = LoggerUtil.getLogger(Hooks.class);
    private static ExtentReports extent;
    private static ExtentTest etest;

    @BeforeAll
    public static void startReport(){
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extent-report.html");

        sparkReporter.config().setDocumentTitle("NexusHR Automation Report");
        sparkReporter.config().setReportName("NexusHR Test Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        logger.info("ExtentReports initialized");
    }

    @Before
    public void setUp(Scenario scenario) {
        DriverFactory.initDriver();
        DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");

        etest = extent.createTest(scenario.getName());

        logger.info("Browser launched and application opened");
        logger.info("Extent test created for scenario: {}", scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Failure Screenshot");
            etest.fail("Scenario failed")
                    .addScreenCaptureFromBase64String(
                            Base64.getEncoder().encodeToString(screenshot),
                            "Failure Screenshot"
                    );
        }
        else {
            etest.pass("Scenario passed");
        }

        logger.info("Closing browser session");

       DriverFactory.getDriver().quit();
    }

    @AfterAll
    public static void endReport(){
        extent.flush();

        logger.info("ExtentReports flushed to target/extent-report.html");
    }
}
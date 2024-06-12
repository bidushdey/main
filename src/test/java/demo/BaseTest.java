package demo;

import java.time.Duration;
import java.util.logging.Level;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest{

    public static ChromeDriver driver;

    @BeforeSuite
    public void startBrowser()
    {
        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30l));
    }

    // @BeforeTest
    
    // public void openUrl()
    // {
    //    driver.get("https://www.flipkart.com/");
    // }

    @BeforeMethod
    public void openUrl()
    {
        System.out.println("Opening the url.");
        driver.get("https://www.scrapethissite.com/pages/");
    }

    @AfterSuite
    public void closeBrowser()
    {
       System.out.println("End Test: TestCases");
       driver.quit();
    }
}
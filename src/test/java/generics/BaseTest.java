package generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected static WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;

    String URL;

    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) throws IOException {
        // Initialize ExtentReports (moved to a centralized initialization)
        if (extent == null) {
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");
            htmlReporter.config().setDocumentTitle("Test Automation Report");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }

        // Load URL from config.properties
        Properties pr = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\subha\\Documents\\workspace-spring-tool-suite-4-4.22.1.RELEASE\\OpenCart\\src\\test\\resources\\config.properties");
        pr.load(fis);
        URL = pr.getProperty("URL");

        // Initialize WebDriver based on parameter passed from TestNG XML or system property
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup(); // Use WebDriverManager for Chrome
            if (driver == null) {
                driver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup(); // Use WebDriverManager for Firefox
            if (driver == null) {
                driver = new FirefoxDriver();
            }
        }

        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
    }

    @AfterClass
    public void teardown() {
        // Flush ExtentReports after each test class
        extent.flush();
        
    }
    @AfterTest
    public void finish() {
    	driver.quit();
    }
}

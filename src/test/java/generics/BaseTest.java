package generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class BaseTest {

    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    String URL;

    @BeforeTest
    public void setup() throws IOException {
        // Initialize ExtentReports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Initialize WebDriver
        driver = new ChromeDriver();

        // Load URL from config.properties
        Properties pr = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\subha\\Documents\\workspace-spring-tool-suite-4-4.22.1.RELEASE\\OpenCart\\src\\test\\resources\\config.properties");
        pr.load(fis);
        URL = pr.getProperty("URL");
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterTest
    public void teardown() {
        // Flush and close ExtentReports
        extent.flush();
        // Quit WebDriver
        driver.quit();
    }
}

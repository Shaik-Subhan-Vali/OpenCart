package generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	
	protected WebDriver driver;
	String URL;
	
	@BeforeTest
	public void setup() throws IOException, InterruptedException {
		
		driver = new ChromeDriver();
		Properties pr = new  Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\subha\\Documents\\workspace-spring-tool-suite-4-4.22.1.RELEASE\\OpenCart\\src\\test\\resources\\config.properties");
		pr.load(fis);
		URL = pr.getProperty("URL");
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
	}
	@AfterTest
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}

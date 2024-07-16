package generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeTest
	public void setup() throws IOException {
		
		driver = new ChromeDriver();
		String URL = "https://www.opencart.com/index.php?route=common/home&member_token=0dd3d6477ecbda23f5f97d20b3aeaf88";
	
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

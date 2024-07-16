package Tests;

import java.time.Duration;

import org.testng.annotations.Test;

import Pages.RegisterPage;
import generics.BaseTest;

public class RegisterTest extends BaseTest{

	RegisterPage RP;
	
	@Test
	public void tc1()  {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		RP = new RegisterPage(driver);
	    RP.creatingAccount();
	    
	}
}

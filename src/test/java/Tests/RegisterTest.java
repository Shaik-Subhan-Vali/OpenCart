package Tests;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.RegisterPage;
import generics.BaseTest;

public class RegisterTest extends BaseTest{

	RegisterPage RP;
	LoginPage LP;
	
	@Test
	public void tc1()  {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		RP = new RegisterPage(driver);
	    String act = RP.creatingAccount();
		String exp ="Your Account Has Been Created!";
		Assert.assertEquals(exp, act);
	}
	@Test
	public void tc2()  {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LP = new LoginPage(driver); 
	    String[] act = LP.logging_in();
		String exp1 ="My Account";
		String exp2 ="Your Store";
		
		Assert.assertEquals(exp1, act[0]);
		Assert.assertEquals(exp2, act[1]);
	}
}

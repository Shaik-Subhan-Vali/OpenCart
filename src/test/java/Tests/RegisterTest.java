package Tests;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.RegisterPage;
import generics.BaseTest;

public class RegisterTest extends BaseTest{

	RegisterPage RP;
	LoginPage LP;
	public String em;
	
	//mvn clean test -Dsurefire.suiteXmlFiles=C:\Users\subha\Documents\workspace-spring-tool-suite-4-4.22.1.RELEASE\OpenCart\src\test\resources\parallel.xml
	
	@Test(priority = 0)
	public void tc1() throws IOException  {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		RP = new RegisterPage(driver);
	    String[] act = RP.creatingAccount();
		String exp ="Your Account Has Been Created!";
		Assert.assertEquals(exp, act[0]);
		 em = act[1];
	}
	
	@Test(dependsOnMethods = "tc1")
	 public void tc2() throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LP = new LoginPage(driver); 
        String[] act = LP.logging_in(em);
        String exp1 = "My Account";
        String exp2 = "Your Store";
        Assert.assertEquals(exp1, act[0]);
        Assert.assertEquals(exp2, act[1]);
    }
}



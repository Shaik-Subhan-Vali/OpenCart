package Tests;

import org.testng.annotations.Test;

import Pages.RegisterPage;
import generics.BaseTest;

public class RegisterTest extends BaseTest{

	RegisterPage RP;
	
	@Test
	public void ordertest() {
		RP = new RegisterPage(driver);
		RP.Registration();
		
	}

}

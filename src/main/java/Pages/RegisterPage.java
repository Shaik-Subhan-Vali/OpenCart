package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	//Web driver constructor
    WebDriver driver;
	
	public RegisterPage(WebDriver driver) 
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);

    }
	
	//objects for Register page

	@FindBy(css = "div>[href=\"https://www.opencart.com/index.php?route=account/register\"]")
	private WebElement Registerbtn;
	

	//Getter methods to access objects
	public WebElement getRegisterbtn() {
		return Registerbtn;
	}

	//businness mthds
	public void Registration() {
		Registerbtn.click();
	}
	
	
}


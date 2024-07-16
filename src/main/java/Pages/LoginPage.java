package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Web driver constructor
    WebDriver driver;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);

    }
	
	//Object repository and getter methods
	@FindBy( css = "[class=\"dropdown\"] [class=\"hidden-xs hidden-sm hidden-md\"]")
	private WebElement myaccount;

	public WebElement getMyaccount() {
		return myaccount;
	}
	
	@FindBy( css = "[class=\"dropdown-menu dropdown-menu-right\"] [href=\"https://tutorialsninja.com/demo/index.php?route=account/login\"]")
	private WebElement login;

	public WebElement getLogin() {
		return login;
	}
	
	@FindBy( id = "input-email")
	private WebElement email;

	public WebElement Email() {
		return email;
	}
	
	@FindBy( id = "input-password")
	private WebElement pwd;

	public WebElement password() {
		return pwd;
	}
	@FindBy( css = "[value=\"Login\"]")
	private WebElement loginbtn;

	public WebElement Log() {
		return loginbtn;
	}
	@FindBy( css = "[class=\"dropdown-menu dropdown-menu-right\"] [href=\"https://tutorialsninja.com/demo/index.php?route=account/logout\"]")
	private WebElement logoutbtn;

	public WebElement Logout() {
		return logoutbtn;
	}
	@FindBy( css = "[class=\"btn btn-primary\"]")
	private WebElement continuebtn;

	public WebElement cont() {
		return continuebtn;
	}
	
	//Business methods
	
	public String[] logging_in() {
		
		myaccount.click();
		login.click();
		email.sendKeys("");
		pwd.sendKeys("");
		login.click();
		String act1 = driver.getTitle();
		myaccount.click();
		logoutbtn.click();
		continuebtn.click();
		String act2 = driver.getTitle();
		return new String[] { act1, act2 };
		
	}

}

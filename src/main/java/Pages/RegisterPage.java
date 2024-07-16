package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
	
	//Web driver constructor
    WebDriver driver;
	
	public RegisterPage(WebDriver driver) 
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);

    }
	
	//objects & getter methods for Register page
 
	@FindBy( css = "[class=\"dropdown\"] [class=\"hidden-xs hidden-sm hidden-md\"]")
	private WebElement myaccount;

	public WebElement getMyaccount() {
		return myaccount;
	}
	
	@FindBy( css = "[href=\"https://tutorialsninja.com/demo/index.php?route=account/register\"]")
	private WebElement register;

	public WebElement registration() {
		return register;
	}
	
	@FindBy( id = "input-firstname")
	private WebElement fname;

	public WebElement firstname() {
		return fname;
	}
	
	@FindBy( id = "input-lastname")
	private WebElement lname;

	public WebElement lastname() {
		return lname;
	}
	
	@FindBy( id = "input-email")
	private WebElement email;

	public WebElement Email() {
		return email;
	}
	
	@FindBy( id = "input-telephone")
	private WebElement telephone;

	public WebElement Telephone() {
		return telephone;
	}
	
	@FindBy( id = "input-password")
	private WebElement pwd;

	public WebElement password() {
		return pwd;
	}
	
	@FindBy( id = "input-confirm")
	private WebElement pwdc;

	public WebElement confirm() {
		return pwdc;
	}
	
	@FindBy( css = "[name=\"newsletter\"][value=\"1\"]")
	private WebElement subscribe;

	public WebElement Subscribe() {
		return subscribe;
	}
	
	@FindBy( css = "[name=\"agree\"]")
	private WebElement policy;

	public WebElement agree() {
		return policy;
	}
	@FindBy( css = "[class=\"btn btn-primary\"]")
	private WebElement submit;

	public WebElement continuebtn() {
		return submit;
	}
	
	
	public void creatingAccount() {
		myaccount.click();
		register.click();
		fname.sendKeys("shaik");
		lname.sendKeys("subhan");
		email.sendKeys("subhan77@gmail.com");
		telephone.sendKeys("9876543210");
		pwd.sendKeys("subahn@888");
		pwdc.sendKeys("subahn@888");
		subscribe.click();
		policy.click();
		submit.click();	
		
	}
	

	
	
}


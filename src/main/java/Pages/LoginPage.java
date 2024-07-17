package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    // WebElement declarations using @FindBy

    @FindBy(css = "[class=\"dropdown\"] [class=\"hidden-xs hidden-sm hidden-md\"]")
    private WebElement myaccount;

    @FindBy(css = "[class=\"dropdown-menu dropdown-menu-right\"] [href=\"https://tutorialsninja.com/demo/index.php?route=account/login\"]")
    private WebElement login;

    @FindBy(id = "input-email")
    private WebElement email;

    @FindBy(id = "input-password")
    private WebElement pwd;

    @FindBy(css = "[value=\"Login\"]")
    private WebElement loginbtn;

    @FindBy(css = "[class=\"dropdown-menu dropdown-menu-right\"] [href=\"https://tutorialsninja.com/demo/index.php?route=account/logout\"]")
    private WebElement logoutbtn;

    @FindBy(css = "[class=\"btn btn-primary\"]")
    private WebElement continuebtn;

    // Constructor to initialize WebDriver and PageFactory
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to perform login using the generated email
    public String[] logging_in(String em) throws IOException {
        myaccount.click();
        logoutbtn.click();
        continuebtn.click();

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\subha\\Documents\\workspace-spring-tool-suite-4-4.22.1.RELEASE\\OpenCart\\src\\test\\resources\\config.properties");
        prop.load(fis);

        myaccount.click();
        login.click();

        email.sendKeys(em);
        pwd.sendKeys(prop.getProperty("password"));
        loginbtn.click();

        String act1 = driver.getTitle();

        myaccount.click();
        logoutbtn.click();
        continuebtn.click();

        String act2 = driver.getTitle();

        return new String[]{act1, act2};
    }
}

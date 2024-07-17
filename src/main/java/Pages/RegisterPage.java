package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    
    private String em; // Variable to store generated email
    private WebDriver driver;
    
    // Constructor to initialize WebDriver and generate email
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        generateAndSetEmail(); // Generate email during object creation
    }
    
    // WebElement declarations using @FindBy
    
    @FindBy(css = "[class=\"dropdown\"] [class=\"hidden-xs hidden-sm hidden-md\"]")
    private WebElement myaccount;
    
    @FindBy(css = "[href=\"https://tutorialsninja.com/demo/index.php?route=account/register\"]")
    private WebElement register;
    
    @FindBy(id = "input-firstname")
    private WebElement fname;
    
    @FindBy(id = "input-lastname")
    private WebElement lname;
    
    @FindBy(id = "input-email")
    private WebElement email;
    
    @FindBy(id = "input-telephone")
    private WebElement telephone;
    
    @FindBy(id = "input-password")
    private WebElement pwd;
    
    @FindBy(id = "input-confirm")
    private WebElement pwdc;
    
    @FindBy(css = "[name=\"newsletter\"][value=\"1\"]")
    private WebElement subscribe;
    
    @FindBy(css = "[name=\"agree\"]")
    private WebElement policy;
    
    @FindBy(css = "[class=\"btn btn-primary\"]")
    private WebElement submit;
    
    // Method to generate a random string of given length
    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
    
    // Method to generate email and store in 'em'
    private void generateAndSetEmail() {
        String randomString = generateRandomString(5);
        em = randomString + "@gmail.com";
    }
    
    // Getter method to retrieve generated email
    public String getEm() {
        return em;
    }
    
    
    
    // Method to perform account registration using generated email
    public String[] creatingAccount() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\subha\\Documents\\workspace-spring-tool-suite-4-4.22.1.RELEASE\\OpenCart\\src\\test\\resources\\config.properties");
        prop.load(fis);
        
        myaccount.click();
        register.click();
        fname.sendKeys(prop.getProperty("firstname"));
        lname.sendKeys(prop.getProperty("lastname"));
        email.sendKeys(em); // Use the generated email
        String x = em ;
        telephone.sendKeys(prop.getProperty("telephone"));
        pwd.sendKeys(prop.getProperty("password"));
        pwdc.sendKeys(prop.getProperty("confirm_password"));
        subscribe.click();
        policy.click();
        submit.click();
        
        String act = driver.getTitle();
        return new String[]{act, x};
 
    }
}

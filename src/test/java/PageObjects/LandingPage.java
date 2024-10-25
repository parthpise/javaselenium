package PageObjects;

import AbstractComponents.Abstract;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends Abstract {
    public WebDriver driver;

    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "userEmail")
    WebElement userID;
    @FindBy(id = "userPassword" )
    WebElement pass;

    @FindBy(id = "login" )
    WebElement submit;

    @FindBy(css="[aria-label='Incorrect email or password.']")
    WebElement LoginError;


    public ProductCatalogue LoginToApplication(String username, String Password){
        userID.sendKeys(username);
        pass.sendKeys(Password);
        submit.click();
        ProductCatalogue pk = new ProductCatalogue(driver);
        return pk;
    }

    public String LoginErrorValidation(){
        String erormessage =LoginError.getText();
        return erormessage;
    }

}

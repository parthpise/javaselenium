package PageObjects;

import AbstractComponents.Abstract;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderValidation extends Abstract {
    public WebDriver driver;
    public OrderValidation(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="h1.hero-primary")
    WebElement ThankyouMessage;

    String thanks = "THANKYOU FOR THE ORDER.";

    public Boolean verifyThankyoumessage(){
        Boolean message = ThankyouMessage.getText().equals(thanks) ;
        return message;
    }
}

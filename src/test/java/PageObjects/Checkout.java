package PageObjects;

import AbstractComponents.Abstract;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import  AbstractComponents.Abstract.ClickByJs;

public class Checkout extends Abstract {
    public WebDriver driver;
    public Checkout(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="input[placeholder='Select Country']")
    WebElement SelectCountry;

    @FindBy(css = "button.ng-star-inserted:nth-of-type(2)")
    WebElement dropdownInd;

    @FindBy(css = ".actions i")
    WebElement CheckoutByjs;

    public void selectIndia(String country){
        SelectCountry.sendKeys(country);
        dropdownInd.click();
    }

    public OrderValidation checkoutclick(){
        ClickByJs(CheckoutByjs,driver);
        OrderValidation ov = new OrderValidation(driver);
        return ov;
    }
}

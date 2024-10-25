package PageObjects;

import AbstractComponents.Abstract;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyCart extends Abstract {
    public WebDriver driver;
    public MyCart(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".cartSection h3")
    List<WebElement> allitemsinCart;

    @FindBy(css = ".totalRow button")
    WebElement checkout;

    public boolean cartValidationItem(String productname){
        Boolean ispresent = allitemsinCart.stream().anyMatch(item->item.getText().equals(productname)) ;
        return ispresent;
    }

    public Checkout clickonCheckout(){
        checkout.click();
        Checkout ck = new Checkout(driver);
        return ck;
    }
}

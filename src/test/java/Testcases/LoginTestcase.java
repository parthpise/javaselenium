package Testcases;

import PageObjects.MyCart;
import PageObjects.ProductCatalogue;
import TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTestcase extends BaseTest {


    @Test()
    public void landingpage(){
        ProductCatalogue pc =lp.LoginToApplication("parthpise521@gmail.com","Partha@121");
        List<WebElement> products= pc.listOfallElements();
        pc.addproductTocart("ZARA COAT 3");
        MyCart mk = pc.CartClick();
    }

}

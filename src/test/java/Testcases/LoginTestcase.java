package Testcases;

import PageObjects.Checkout;
import PageObjects.MyCart;
import PageObjects.OrderValidation;
import PageObjects.ProductCatalogue;
import TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTestcase extends BaseTest {

//Testcase 1
    @Test()
    public void landingpage(){
        ProductCatalogue pc =lp.LoginToApplication("parthpise521@gmail.com","Partha@121");
        List<WebElement> products= pc.listOfallElements();
        pc.addproductTocart("ZARA COAT 3");
        MyCart mk = pc.CartClick();
        Checkout ck = mk.clickonCheckout();
        ck.selectIndia("Ind");
        OrderValidation ov  =ck.checkoutclick();
        Boolean statusofmessage = ov.verifyThankyoumessage();
        Assert.assertTrue(statusofmessage);
    }

}

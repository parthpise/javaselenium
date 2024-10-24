package Testcases;

import TestComponents.BaseTest;
import org.testng.annotations.Test;

public class LoginTestcase extends BaseTest {


    @Test()
    public void landingpage(){
        lp.LoginToApplication("parthpise521@gmail.com","Partha@121");
    }

}

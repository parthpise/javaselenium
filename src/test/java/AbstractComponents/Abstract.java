package AbstractComponents;

import PageObjects.MyCart;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Abstract {
    public WebDriver driver;

    public Abstract(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[routerlink='/dashboard/cart']")
    WebElement cart;

    public void waitForElementByvisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitForElementToInvisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void waitForElementToDisappear(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void ClickByJs(WebElement elementToClickByjs, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", elementToClickByjs);
    }

    public void gotoUrl() {
        driver.get("https://rahulshettyacademy.com/client");
    }

    public MyCart CartClick() {
        cart.click();
        MyCart mk = new MyCart(driver);
        return mk;
    }
}

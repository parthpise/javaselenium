import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class standalone {
    public  static WebDriver driver;

    public static void ClickByJs( WebElement elementToClickByjs, WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", elementToClickByjs);
    }
    public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver","D:\\chromedrivers\\chromedriver-130\\chromedriver-win64\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.get("https://rahulshettyacademy.com/client/");
    driver.findElement(By.id("userEmail")).sendKeys("parthpise521@gmail.com");
    driver.findElement(By.id("userPassword")).sendKeys("Partha@121");
    driver.findElement(By.id("login")).click();
    List< WebElement> products =driver.findElements(By.cssSelector(".mb-3"));
    WebElement prod =products.stream().filter(product -> product.findElement(By.cssSelector(".card-body b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
    prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

    WebElement cart =driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']"));
    cart.click();


    WebElement nameOfProduct = driver.findElement(By.cssSelector(".cartSection h3"));
    Boolean isPresnt = nameOfProduct.getText().equals("ZARA COAT 3");
    Assert.assertTrue(isPresnt);

    WebElement checkout =driver.findElement(By.cssSelector(".totalRow button"));
    checkout.click();

    WebElement selectCountry = driver.findElement(By.cssSelector("input[placeholder='Select Country']"));
    selectCountry.sendKeys("Ind");

    WebElement dropdownInd = driver.findElement(By.cssSelector("button.ng-star-inserted:nth-of-type(2)"));
    dropdownInd.click();

        WebElement elementToClickByjs = driver.findElement(By.cssSelector(".actions i"));
        ClickByJs(elementToClickByjs, driver);

        WebElement thankyouForOrder = driver.findElement(By.cssSelector("h1.hero-primary"));
        boolean ID = thankyouForOrder.getText().equals("THANKYOU FOR THE ORDER.");
        Assert.assertTrue(ID);

        driver.quit();
    }
}

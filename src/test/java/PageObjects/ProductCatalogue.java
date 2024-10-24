package PageObjects;

import AbstractComponents.Abstract;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends Abstract {
    public WebDriver driver;

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement spinner;

    By addtocart = By.cssSelector(".card-body button:last-of-type");

    By product = By.cssSelector(".mb-3");

    By toaster = By.cssSelector("#toast-container");

    public List<WebElement> listOfallElements() {
        waitForElementToInvisible(product);
        return products;
    }

    public WebElement productAddtoCart(String nameOfText) {
        WebElement prod = products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(nameOfText)).findFirst().orElse(null);
        return prod;
    }

    public void addproductTocart(String nameofText) {
        WebElement prod = productAddtoCart(nameofText);
        prod.findElement(addtocart).click();
        waitForElementByvisible(toaster);
        waitForElementToDisappear(spinner);
    }


}

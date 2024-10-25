package TestComponents;

import PageObjects.LandingPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public LandingPage lp;

    public WebDriver InitializetheChrome() throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//Resources//globalData.properties");
        prop.load(file);

        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","D:\\chromedrivers\\chromedriver-130\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     return driver;
    }

    //Utility to take screenshot
  public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
      TakesScreenshot ts = (TakesScreenshot) driver;
      File source = ts.getScreenshotAs(OutputType.FILE);
      File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+ ".png");
      FileUtils.copyFile(source,file);
      return System.getProperty("user.dir")+ "//reports" + testCaseName + ".png";
  }
    @BeforeMethod(alwaysRun = true)
    public void Launchbrowser() throws IOException {
        driver = InitializetheChrome();
        lp = new LandingPage(driver);
        lp.gotoUrl();

    }

    @AfterMethod(alwaysRun = true)
    public void closebrowser(){
        driver.quit();
    }


}

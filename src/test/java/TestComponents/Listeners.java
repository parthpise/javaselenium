package TestComponents;

import Resources.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    ExtentTest test;
    @Override
    public void onTestStart(ITestResult result) {
        test =extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS,"Test Passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
           e.printStackTrace();
        }
        String Filepath = null;
        try {
            Filepath = getScreenshot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
          e.printStackTrace();
        }
        extentTest.get().addScreenCaptureFromPath(Filepath,result.getMethod().getMethodName());
       extentTest.get().log(Status.FAIL,"Test Failed");
    }
    @Override
    public void  onTestSkipped(ITestResult result) {
        // not implemented
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
    }
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }
    @Override
    public void onFinish(ITestContext context) {
       extent.flush();
    }
}

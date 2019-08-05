package com.schoology.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.schoology.utilities.ConfigurationReader;
import com.schoology.utilities.Driver;
import com.schoology.utilities.SchoologyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {  //abstract because we dont want instance from this class
    protected WebDriver driver;
    protected Actions actions;
    protected SoftAssert softAssert;
    protected WebDriverWait wait;
    //protected Pages pages;
    protected static ExtentReports report;
    private static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentLogger;
    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUpMethod(@Optional String browser){
        driver=Driver.getDriver(browser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        softAssert=new SoftAssert();
        actions=new Actions(driver);
        wait=new WebDriverWait(driver,10);
        //pages=new Pages();
        driver.get(ConfigurationReader.getProperty("url"));
    }
    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE){
            String screenshotLocation= SchoologyUtils.getScreenshot(result.getName());
            extentLogger.fail(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshotLocation);
            extentLogger.fail(result.getThrowable());
        }
        else if (result.getStatus()==ITestResult.SKIP){
            extentLogger.skip("Test Case Skipped: "+result.getName());
        }
        Driver.closeDriver();
        softAssert.assertAll();
    }
    @BeforeTest(alwaysRun = true)
    public void setUpTest(){
        report =new ExtentReports();
        String filePath=System.getProperty("user.dir")+"/test-output/report.html";
        htmlReporter=new ExtentHtmlReporter(filePath);
        report.attachReporter(htmlReporter);
        report.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
        report.setSystemInfo("Environment", "Extent Reports with Selenium WebDriver");
        report.setSystemInfo("QA Engineer:", " Yasin Bekar");
        htmlReporter.config().setDocumentTitle("Schoology Automation  Project ");
    }
    @AfterTest(alwaysRun = true)
    public void endReport() {
        report.flush();
    }
}

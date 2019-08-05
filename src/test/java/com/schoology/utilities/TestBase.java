package com.schoology.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    public Actions action;

    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    @BeforeTest
    public void testSetup(){
        report = new ExtentReports();
        String pathToReport = (System.getProperty("user.dir") + "/test-output/report.html");
        htmlReporter = new ExtentHtmlReporter(pathToReport);
        report.attachReporter(htmlReporter);
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Environment", "Extent Reports with Selenium WebDriver");
        report.setSystemInfo("QA Engineer:", " Yasin Bekar");
        htmlReporter.config().setDocumentTitle("Schoology Automation  Project ");
    }

    @BeforeMethod
    public void  setup(){
        driver = Driver.getDriver();
        action = new Actions(driver);
        driver .manage().timeouts().implicitlyWait(Long.valueOf(ConfigurationReader.getProperty("implicitwait")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("url"));

    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            String pathToTheScreenshot = SchoologyUtils.getScreenshot(result.getName());
            extentLogger.fail(result.getName());
            try{
               extentLogger.addScreenCaptureFromPath(pathToTheScreenshot);
            }catch(IOException e){
                e.printStackTrace();
            }
            extentLogger.fail(result.getThrowable());
        }else if(result.getStatus() == ITestResult.SKIP){
            extentLogger.skip("Tes case skipped " + result.getName());
        }
        Driver.closeDriver();
    }

    @AfterTest
    public void tearDownTest(){
       //Flush method is used to erase any previous data on the report and create a new report.
        report.flush();
    }
}

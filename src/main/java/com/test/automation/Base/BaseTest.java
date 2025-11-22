package com.test.automation.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.test.automation.utils.ExtentReportManager;
import com.test.automation.utils.Log;

public class BaseTest {
    
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;



    @BeforeSuite
    public void setupReport(){
        
        extent = ExtentReportManager.getReportInstance();
    }
    
    @AfterSuite
    public void teardownReport(){
        extent.flush();
    }

   @BeforeMethod
    public void setUp(){
        Log.info("Setting up the Webdriver for Chrome Browser...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Log.info("Navigating to the URL...");
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
            
       

    }


    @AfterMethod
    public void tearDown(ITestResult result){

        if(result.getStatus() == ITestResult.FAILURE){
            String screenshotPath = ExtentReportManager.captureScreenshot(driver, "LoginFailure");
            System.out.println("Test Failed");
            test.fail("Test Failed....check screenshot attahced.", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

        }

        if (driver != null) {

            Log.info("Capturing screenshots...");

            Log.info("Closing the Web browser.");
            driver.quit();
        }
        
    }

}

package tests;


import org.testng.Assert;
import org.testng.annotations.Test;


import com.test.automation.Base.BaseTest;
import com.test.automation.Pages.LoginPage;
import com.test.automation.utils.ExtentReportManager;
import com.test.automation.utils.Log;

public class LoginTest extends BaseTest {    //LoginTes inherits BaseTest
    
    @Test
    public void TestValidLogin(){
        Log.info("Starting LoginTest... ");
        test = ExtentReportManager.createTest("Login Test");
        test.info("Navigating to the URL...");
        LoginPage loginpage = new LoginPage(driver);  //driver taken from BaseTest.java class
        String title = driver.getTitle();
        System.out.println("Title of the page is: "+ title);
        Log.info("Providing Login Credentials... ");
        test.info("Providing Credentials");
        loginpage.enterUsername("admin@youstore.com");
        loginpage.enterPassword("admin");
        test.info("Clicking the Login button");
        loginpage.clickLogin();
        Assert.assertEquals(title, "ABC 123");

        

    }

}

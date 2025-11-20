package tests;

import org.testng.annotations.Test;

import com.test.automation.Base.BaseTest;
import com.test.automation.Pages.LoginPage;

public class LoginTest extends BaseTest {    //LoginTes inherits BaseTest
    
    @Test
    public void TestValidLogin(){
        LoginPage loginpage = new LoginPage(driver);  //driver taken from BaseTest.java class
        System.out.println("Title of the page is: "+ driver.getTitle());
        loginpage.enterUsername("admin@youstore.com");
        loginpage.enterPassword("admin");
        loginpage.clickLogin();

        

    }

}

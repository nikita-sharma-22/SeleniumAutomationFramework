package tests;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.Base.BaseTest;
import com.test.automation.Pages.LoginPage;
import com.test.automation.utils.ExcelUtils;
import com.test.automation.utils.ExtentReportManager;
import com.test.automation.utils.Log;

public class LoginTest extends BaseTest {    //LoginTes inherits BaseTest

     @DataProvider(name="LoginData")
    public Object[][] getLoginData() throws IOException{

        String filePath = System.getProperty("user.dir") + "/test_data/TestData.xlsx";
        ExcelUtils.loadExcel(filePath, "Sheet1");
        int rowCount = ExcelUtils.getRowCount();
        Object[][] data = new Object[rowCount-1][2];    //Discard Header row. Currently there are also two columns
        for(int i=1; i<rowCount; i++){
            data[i-1][0] = ExcelUtils.getCellData(i, 0); //Username
            data[i-1][1] = ExcelUtils.getCellData(i, 1); // Password

        }
        ExcelUtils.closeExcel();
        return data;    
    }

    //Data Provider Method for small data combos
    @DataProvider(name = "LoginData2")
    public Object[][] getData(){
        return new Object[][]{
            {"user1", "pass1"},
            {"user2", "pass2"},
            {"user3", "pass3"},
            {"admin@youstore.com", "admin"}
        };
    }   

    @Test(dataProvider = "LoginData2")
    public void TestValidLogin(String username, String password){
        Log.info("Starting LoginTest... ");
        test = ExtentReportManager.createTest("Login Test");
        test.info("Navigating to the URL...");
        LoginPage loginpage = new LoginPage(driver);  //driver taken from BaseTest.java class
        String title = driver.getTitle();
        System.out.println("Title of the page is: "+ title);
        Log.info("Providing Login Credentials... ");
        test.info("Providing Credentials");
        loginpage.enterUsername(username);
        loginpage.enterPassword(password);
        test.info("Clicking the Login button");
        loginpage.clickLogin();
        //Assert.assertEquals(title, "ABC 123");

        

    }

}

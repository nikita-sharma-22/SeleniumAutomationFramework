package com.test.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.automation.utils.Log;

public class LoginPage {
    
    private WebDriver driver;
    
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//input[@value = 'Log In']");

    public LoginPage(WebDriver driver){   //constrructor created and called by default when class object is created.
        this.driver = driver;
    }

    public void enterUsername(String username){
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin(){
        Log.info("Clicking Login button...");
        driver.findElement(loginButton).click();
    }


}

package com.test.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.utils.Log;

public class LoginPage {
    
    private WebDriver driver;

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value = 'Log In']")
    private WebElement loginButton;
    
    // private By usernameField = By.name("username");
    // private By passwordField = By.name("password");
    // private By loginButton = By.xpath("//input[@value = 'Log In']");

    public LoginPage(WebDriver driver){   //constrructor created and called by default when class object is created.
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin(){
        Log.info("Clicking Login button...");
        loginButton.click();
    }


}

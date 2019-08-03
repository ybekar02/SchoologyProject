package com.schoology.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.schoology.utilities.Driver;

public class LoginPage {

    private WebDriver driver = Driver.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 5);

    @FindBy (id ="edit-mail")
    public WebElement userNameElement;

    @FindBy (id ="edit-pass")
    public WebElement passwordElement;

    @FindBy (id ="edit-submit")
    public WebElement submitElement;

    @FindBy (css = ".message-text")
    public WebElement errorElement;


    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password){
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        submitElement.click();
    }

    public String getErrorMessage(){
        return errorElement.getText();
    }

}

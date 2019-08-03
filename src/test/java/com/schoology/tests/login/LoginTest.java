package com.schoology.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.schoology.pages.login.LoginPage;
import com.schoology.utilities.ConfigurationReader;
import com.schoology.utilities.Driver;
import com.schoology.utilities.TestBase;

public class LoginTest extends TestBase {

    @Test
    public void loginTest() {
        extentLogger = report.createTest("Login as a Schoology user");

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");

        loginPage.login(username, password);

        //String title = Driver.getDriver().findElement(By.xpath("//title")).getText();
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.equals("Home | Schoology"));

        extentLogger.pass("Verified that user has valid credentials");

    }

    @Test
    public void loginNegativeTest() {
        extentLogger = report.createTest("User should not be able to login with wrong credentials");

        LoginPage loginPage = new LoginPage();

        loginPage.login("Hello", "World");

        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.equals("Login to Schoology"));
        System.out.println(loginPage.getErrorMessage());

        extentLogger.pass("User could not login with the wrong credentials");
    }
}
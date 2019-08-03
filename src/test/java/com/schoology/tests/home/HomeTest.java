package com.schoology.tests.home;

import org.testng.annotations.Test;
import com.schoology.pages.home.HomePage;
import com.schoology.pages.login.LoginPage;
import com.schoology.utilities.ConfigurationReader;
import com.schoology.utilities.TestBase;

public class HomeTest extends TestBase {

    @Test
    public void logOnPage()throws Exception{
        extentLogger = report.createTest("Logging the homepage");
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");

        loginPage.login(username, password);

        homePage.logOn();
        extentLogger.pass("User could log on the home page successfully!");
    }




}



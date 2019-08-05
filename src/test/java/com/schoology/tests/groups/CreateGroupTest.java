package com.schoology.tests.groups;

import com.schoology.pages.groups.CreateGroupsPage;
import com.schoology.pages.login.LoginPage;
import com.schoology.utilities.ConfigurationReader;
import com.schoology.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class CreateGroupTest extends TestBase {

    @Test
    public void group(){
        extentLogger = report.createTest("Creating groups");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username, password);

        CreateGroupsPage createGroupsTest = new CreateGroupsPage();
        createGroupsTest.groupButtonElement.click();
        createGroupsTest.createGroupButtonElement.click();
        createGroupsTest.nameElement.click();
        createGroupsTest.nameElement.sendKeys("Coders");
        createGroupsTest.descriptionElement.sendKeys("Selenium TestNG Group");
        createGroupsTest.privacy();
        createGroupsTest.access();
        createGroupsTest.category();
        createGroupsTest.creatbuttonElement.click();

        extentLogger.pass("Successfully created the Coder`s group");
    }




}

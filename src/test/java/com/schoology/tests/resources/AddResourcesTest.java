package com.schoology.tests.resources;

import com.schoology.pages.login.LoginPage;
import com.schoology.pages.resources.AddResourcesPage;
import com.schoology.utilities.ConfigurationReader;
import com.schoology.utilities.SchoologyUtils;
import com.schoology.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddResourcesTest extends TestBase {

    @Test
    public void resources(){

        extentLogger = report.createTest("Adding files in resources folder");

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username, password);

        AddResourcesPage addResourcesPage = new AddResourcesPage();
        addResourcesPage.resourcesTabElement.click();
        addResourcesPage.addResourcesElement.click();
        SchoologyUtils.waitFor(3);
        addResourcesPage.addFileElement.click();
        SchoologyUtils.waitFor(3);
        addResourcesPage.attachFilesElement.sendKeys("/Users/yasinbekar/Downloads/oracle-certified-associate-java-se-8-programmer.png");
        addResourcesPage.addButtonElement.click();

        extentLogger.pass("Successfully added the file");

    }
}

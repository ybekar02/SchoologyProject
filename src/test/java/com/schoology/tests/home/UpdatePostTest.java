package com.schoology.tests.home;

import org.testng.annotations.Test;
import com.schoology.pages.home.UpdatePostPage;
import com.schoology.pages.login.LoginPage;
import com.schoology.utilities.ConfigurationReader;
import com.schoology.utilities.Driver;
import com.schoology.utilities.SchoologyUtils;
import com.schoology.utilities.TestBase;

public class UpdatePostTest extends TestBase {
    @Test
    public void postUpdate()throws Exception{

        extentLogger = report.createTest("Login as a Schoology user and post an update");

        LoginPage loginPage = new LoginPage();
        UpdatePostPage updatePost = new UpdatePostPage();
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username, password);
        String post = "Welcome to Java";
        String link = "app.schoology.com/home";
        String title = "Title";
        updatePost.updatePostElement.click();
        Driver.getDriver().switchTo().frame("edit-body_ifr");
        updatePost.bodyElement.sendKeys(post);
        SchoologyUtils.waitFor(3);
        Driver.getDriver().switchTo().parentFrame();
        SchoologyUtils.waitFor(3);
        updatePost.insertContentElement.click();
        updatePost.linkElement.click();
        SchoologyUtils.waitFor(3);

        Driver.getDriver().switchTo().frame("mce_52_ifr");
        updatePost.linkBoxElement.sendKeys(link);
        SchoologyUtils.waitFor(3);
        //need to add here clear() method since the box already has "Java" text inside
        updatePost.titleBoxElement.clear();
        updatePost.titleBoxElement.sendKeys(title);
        SchoologyUtils.waitFor(3);
        updatePost.insertElement.click();
        SchoologyUtils.waitFor(3);
        Driver.getDriver().switchTo().defaultContent();
        updatePost.postSearchElement.click();
        updatePost.courseSelectElement.click();
        updatePost.selectElement.click();
        updatePost.postElement.click();

        extentLogger.pass("Verified that user has valid credentials and can post an update");
    }
}
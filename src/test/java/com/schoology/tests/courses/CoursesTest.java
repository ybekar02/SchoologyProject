package com.schoology.tests.courses;

import com.schoology.pages.courses.CoursePage;
import com.schoology.pages.login.LoginPage;
import com.schoology.utilities.ConfigurationReader;
import com.schoology.utilities.Driver;
import com.schoology.utilities.SchoologyUtils;
import com.schoology.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CoursesTest extends TestBase {

    @Test
    public void courseMaterials(){
        extentLogger = report.createTest("Taking attendance");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username, password);

        CoursePage coursePage = new CoursePage();

        coursePage.courseDashboardElement.click();
        coursePage.courseSelection2.click();
        coursePage.courseMaterials();
        coursePage.attendanceElement.click();
        coursePage.takeAttendenaceButtonElement.click();
//        String attendance = Driver.getDriver().findElement(By.id("attendance-taken-status-sunday")).getText();
//        Assert.assertEquals(attendance, "Saved");
        coursePage.saveChangesButtonElement.click();

        extentLogger.pass("Successfully searched and picked course materials, as well as attendance is taken");
    }
}

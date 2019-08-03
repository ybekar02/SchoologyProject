package com.schoology.tests.home;

import com.schoology.pages.home.EventPage;
import com.schoology.pages.login.LoginPage;
import com.schoology.tests.login.LoginTest;
import com.schoology.utilities.ConfigurationReader;
import com.schoology.utilities.Driver;
import com.schoology.utilities.SchoologyUtils;
import com.schoology.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class EventTest extends TestBase {

    @Test
    public void eventTest(){
        extentLogger = report.createTest("Create an event as a user");

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username, password);

        EventPage eventPage = new EventPage();
        eventPage.eventTabElement.click();
        eventPage.clickOnDateElement.click();
        eventPage.searchForMonthElement.click();
        SchoologyUtils.waitForPageToLoad(3);
        month();
        SchoologyUtils.waitForPageToLoad(3);
        day();
        SchoologyUtils.waitForPageToLoad(3);
        eventPage.titleElement.sendKeys("New Assignment!");
        SchoologyUtils.waitForPageToLoad(3);
        Driver.getDriver().switchTo().frame("edit-description_ifr");
        eventPage.bodyElement.sendKeys("Dear students, make sure to check your assignment on the announcement page!");
        Driver.getDriver().switchTo().parentFrame();
        rsvp();
        eventPage.optionsElement.isEnabled();
        eventPage.searchButtonElement.click();
        eventPage.section2CheckBoxElement.click();
        eventPage.selectButtonElement.click();
        eventPage.createButtonElement.click();

        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.equals("Home | Schoology"));
        System.out.println(title);

        extentLogger.pass("User can post the assignment on the Event post successfully");
    }

    public void month(){
        Select select = new Select(Driver.getDriver().findElement(By.cssSelector("select[class='ui-datepicker-new-month']")));
        select.selectByVisibleText("October");
    }

    public void day(){
        WebElement table = Driver.getDriver().findElement(By.cssSelector("table[class='ui-datepicker']"));
        int num = table.findElements(By.xpath("//td[contains(@class,'ui-datepicker-days-cell')]")).size();
        for(int i=0; i< num; i++){
            String day = table.findElements(By.xpath("//td[contains(@class,'ui-datepicker-days-cell')]")).get(i).getText();
            if(day.equals("18"))
                Driver.getDriver().findElements(By.xpath("//td[contains(@class,'ui-datepicker-days-cell')]")).get(i).click();
        }

    }

    public void rsvp(){
        Select select = new Select(Driver.getDriver().findElement(By.cssSelector("select[id='edit-rsvp']")));
        select.selectByVisibleText("Only invitees can RSVP");

    }






}

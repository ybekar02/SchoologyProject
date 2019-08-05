package com.schoology.pages.courses;

import com.schoology.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CoursePage {

    @FindBy(xpath = "//a[text()='Course Dashboard']")
    public WebElement courseDashboardElement;

    @FindBy(xpath = "(//div[@class='sgy-card-lens'])[1]")
    public WebElement courseSelection2;

    @FindBy(css = "li[role='menuitem'] li[class*='leaf']")
    public List<WebElement> classMaterialsElement;

    @FindBy(css = "li[role='menuitem'] li[class*='leaf'] > div > a[href*='attendance']")
    public WebElement attendanceElement;

    @FindBy(id= "attendance-taken-status-sunday")
    public WebElement takeAttendenaceButtonElement;

    @FindBy(id = "edit-submit")
    public WebElement saveChangesButtonElement;

    public CoursePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public void courseMaterials(){
        int num = Driver.getDriver().findElements(By.cssSelector("li[role='menuitem'] li[class*='leaf']")).size();
        for(int i=0; i < num; i++){
            System.out.println(Driver.getDriver().findElements(By.cssSelector("li[role='menuitem'] li[class*='leaf']")).get(i).getText());
        }
    }




}

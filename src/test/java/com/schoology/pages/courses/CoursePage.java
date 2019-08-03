package com.schoology.pages.courses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursePage {

    @FindBy(xpath = "//a[text()='Course Dashboard']")
    public WebElement courseDashboardElement;

    @FindBy(xpath = "(//div[@class='sgy-card-lens'])[1]")
    public WebElement CourseSelection2;

    @FindBy(css = "li[role='menuitem'] li[class*='leaf']")
    public WebElement classMaterialsElement;



}

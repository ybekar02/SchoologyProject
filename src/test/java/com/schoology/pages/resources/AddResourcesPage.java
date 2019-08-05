package com.schoology.pages.resources;

import com.schoology.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddResourcesPage {

    @FindBy(xpath = "//*[text()='Resources']")
    public WebElement resourcesTabElement;

    @FindBy(xpath = "(//div[@role='button'])[3]")
    public WebElement addResourcesElement;

    @FindBy(id ="collection-add-file")
    public WebElement addFileElement;

    @FindBy(xpath = "//input[contains(@id,'html5')]")
    public WebElement attachFilesElement;

    @FindBy(css = "input[id='edit-submit'][value='Add']")
    public WebElement addButtonElement;

    public AddResourcesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }





}

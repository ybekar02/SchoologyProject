package com.schoology.pages.groups;

import com.schoology.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateGroupsPage {

    @FindBy(css = "li[data-sgy-sitenav='header-groups-menu']")
    public WebElement groupButtonElement;

    @FindBy(xpath = "//*[text()='Create a Group']")
    public WebElement createGroupButtonElement;

    @FindBy(css = "input[id='edit-name']")
    public WebElement nameElement;

    @FindBy(css = "textarea[id='edit-description']")
    public WebElement descriptionElement;

    @FindBy(css = "input[id='edit-submit'][value='Create']")
    public WebElement creatbuttonElement;


    public CreateGroupsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void privacy(){
        Select select = new Select(Driver.getDriver().findElement(By.cssSelector("select[name='privacy_level']")));
        select.selectByValue("schoology");
    }

    public void access(){
        Select select = new Select(Driver.getDriver().findElement(By.cssSelector("select[id='edit-invite-type']")));
        select.selectByVisibleText("Allow Requests");
    }

    public void category(){
        Select select = new Select(Driver.getDriver().findElement(By.cssSelector("select[id='edit-category']")));
        select.selectByIndex(5);
    }



}

package com.schoology.pages.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.schoology.utilities.Driver;

public class UpdatePostPage {

    @FindBy(xpath = "//li[contains(@class, 'smart-box-tab-0')]")
    public WebElement updatePostElement;

    @FindBy(xpath = "//*[@id='tinymce']")
    public WebElement bodyElement;

    @FindBy(xpath = "//*[@id='edit-body_insert_content']")
    public WebElement insertContentElement;

    @FindBy(id = "s_insert_link_aria")
    public WebElement linkElement;

    @FindBy(xpath = "//input[@class='mceFocus']")
    public WebElement linkBoxElement;

    @FindBy(xpath = "//input[@id='linktext']")
    public WebElement titleBoxElement;

    @FindBy(css = "#insert")
    public WebElement insertElement;

    @FindBy(id = "browse-realm-button")
    public WebElement postSearchElement;

    @FindBy(css = "#browse-realm-checkbox-course-1519721845")
    public WebElement courseSelectElement;

    @FindBy(id = "popup_submit")
    public WebElement selectElement;

    @FindBy(id = "edit-submit")
    public WebElement postElement;


    public UpdatePostPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}

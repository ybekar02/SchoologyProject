package com.schoology.pages.home;

import com.schoology.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventPage {

    @FindBy(xpath = "//li[contains(@class,'smart-box-tab-2')]")
    public WebElement eventTabElement;

    @FindBy(id= "edit-start-datepicker-popup-0")
    public WebElement clickOnDateElement;

    @FindBy(css = "select[class='ui-datepicker-new-month']")
    public WebElement searchForMonthElement;

    @FindBy(css = "input[id='edit-title']")
    public WebElement titleElement;

    @FindBy(id= "tinymce")
    public WebElement bodyElement;

    @FindBy(css = "div[class$='group-toggle']")
    public WebElement optionsElement;

    @FindBy(id= "browse-realm-button")
    public  WebElement searchButtonElement;

    @FindBy(css = "input[realmtitle='Chem Course: Section 2']")
    public WebElement section2CheckBoxElement;

    @FindBy(id = "popup_submit")
    public WebElement selectButtonElement;

    @FindBy(id = "edit-submit")
    public WebElement createButtonElement;

    public EventPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



}

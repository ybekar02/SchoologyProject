package com.schoology.pages.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.schoology.utilities.Driver;

public class HomePage {

    @FindBy (css = "button[aria-label='Upgrade']")
    public WebElement upgradeButtonElement;

    @FindBy (css = "a[aria-label='Find Out More']")
    public WebElement findOutMoreButtonElement;

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void logOn(){
    upgradeButtonElement.click();
    findOutMoreButtonElement.click();
}

}

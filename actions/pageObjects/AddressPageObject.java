package pageObjects;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressPageUI;
import pageUIs.CustomerInfoPageUI;

public class AddressPageObject extends BasePage {
    private WebDriver driver;

    public AddressPageObject(WebDriver driver){
        this.driver = driver;
    }



}

package pageObjects;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressPageUI;
import pageUIs.RewordPointPageUI;

public class RewardPointPageObject extends BasePage {
    private WebDriver driver;

    public RewardPointPageObject(WebDriver driver){
        this.driver = driver;
    }


}

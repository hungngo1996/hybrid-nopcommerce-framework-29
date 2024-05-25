package pageObjects;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressPageUI;

public class OrderPageObject extends BasePage {
    private WebDriver driver;

    public OrderPageObject(WebDriver driver){
        this.driver = driver;
    }


}

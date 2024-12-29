package pageObjects.saucelabs;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.sauceLabs.LoginPageUI;

public class LoginSaucelabsPO extends BasePage {
    private WebDriver driver;
    public LoginSaucelabsPO(WebDriver driver) {
        this.driver = driver;
    }
    public InventoryPO loginToApplication(String userName, String passWord) {
        waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, userName);
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passWord);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return SaucelabsPageGenerator.getInventoryPage(driver);
    }
}

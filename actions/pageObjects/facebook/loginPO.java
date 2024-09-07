package pageObjects.facebook;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageUIs.facebook.LoginPageUI;

public class loginPO extends BasePage {
    private WebDriver driver;
    public loginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToNewAccountButton() {
        waitForElementClickable(driver, LoginPageUI.CREATE_ACCOUNT_BUTTON);
        clickToElement(driver, LoginPageUI.CREATE_ACCOUNT_BUTTON);
    }
    public void enterToEmailAddressTextbox(String email) {
        waitForElementClickable(driver,LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendKeyToElement(driver,LoginPageUI.EMAIL_ADDRESS_TEXTBOX, email);
    }

    public boolean confirmEmailTextboxdisplayed() {
        waitForElementVisible(driver,LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
        return isElementDisplayed(driver,LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
    }
    public boolean confirmEmailTextboxUndisplayed() {
        waitForElementInvisible(driver,LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
        return isElementUndisplayed(driver,LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
    }
}

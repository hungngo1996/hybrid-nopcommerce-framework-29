package pageObjects.nopCommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.nopCommerce.user.UserLoginPageUI;

public class UserLoginPO extends BasePage {
    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }
    private WebDriver driver;
    public void enterToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
    }

    public UserHomePO loginToSystem(String emailAddress, String password){
        enterToEmailTextBox(emailAddress);
        enterToPasswordTextBox(password);
        clickToLoginButton();
        return PageGenerator.getUserHomePage(driver);
    }
}

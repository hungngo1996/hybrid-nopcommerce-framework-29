package pageObjects.nopCommerce.user;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.user.UserLoginPageUI;

public class UserLoginPO extends BasePage {
    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }
    private WebDriver driver;
    @Step("Enter to Email textbox with value: {0}")
    public void enterToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }
    @Step("Enter to Password textbox with value: {0}")
    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
    }
    @Step("Click to Login button")
    public void clickToLoginButton() {
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
    }
    @Step("Login to system with valid Email and Password")
    public UserHomePO loginToSystem(String emailAddress, String password){
        enterToEmailTextBox(emailAddress);
        enterToPasswordTextBox(password);
        clickToLoginButton();
        return PageGenerator.getUserHomePage(driver);
    }
}

package pageObjects.nopCommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
    WebDriver driver;
    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public AdminDashboardPO clickToLoginButton() {
        waitForElementVisible(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getAdminDashBoardPage(driver);
    }

    public void enterToEmailTextbox(String emailAdress) {
        waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAdress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }

}

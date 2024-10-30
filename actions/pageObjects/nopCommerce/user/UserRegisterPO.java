package pageObjects.nopCommerce.user;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.user.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    @Step("Click to Male radio button")
    public void clickToMaleRadio() {
        waitForElementClickable(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
        checkToCheckboxRadio(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
    }
    @Step("Enter to First Name textbox with value: {0}")
    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }
    @Step("Enter to Last Name textbox with value: {0}")
    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }
    @Step("Select Day dropdown with value item: {0}")
    public void selectDayDropdown(String day) {
        waitForElementClickable(driver, UserRegisterPageUI.DAY_DROPDOWN);
        selectItemInDropdown(driver, UserRegisterPageUI.DAY_DROPDOWN, day);
    }
    @Step("Select Month dropdown with value item: {0}")
    public void selectMonthDropdown(String month) {
        waitForElementClickable(driver, UserRegisterPageUI.MONTH_DROPDOWN);
        selectItemInDropdown(driver, UserRegisterPageUI.MONTH_DROPDOWN, month);
    }
    @Step("Select Year dropdown with value item: {0}")
    public void selectYearDropdown(String year) {
        waitForElementClickable(driver, UserRegisterPageUI.YEAR_DROPDOWN);
        selectItemInDropdown(driver, UserRegisterPageUI.YEAR_DROPDOWN, year);
    }
    @Step("Enter to Email textbox with value: {0}")
    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
    }
    @Step("Enter to Company textbox with value: {0}")
    public void enterToCompanyTextbox(String company) {
        waitForElementVisible(driver, UserRegisterPageUI.COMPANY_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.COMPANY_TEXTBOX, company);
    }
    @Step("Enter to Password textbox with value: {0}")
    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
    }
    @Step("Enter to Confirm Password textbox with value: {0}")
    public void enterToConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }
    @Step("Click to Register button")
    public void clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }
    @Step("Get Register Success Massage")
    public String getRegisterSuccessMassage() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }
    @Step("Open Login page")
    public UserLoginPO openLoginPage() {
        waitForElementVisible(driver, UserRegisterPageUI.LOGIN_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }
    @Step("Click to Logout link")
    public UserHomePO clickToLogoutLink() {
        waitForElementClickable(driver,UserRegisterPageUI.LOGOUT_LINK);
        clickToElement(driver,UserRegisterPageUI.LOGOUT_LINK);
        return PageGenerator.getUserHomePage(driver);
    }
    @Step("Get Register page title")
    public String getRegisterPageTitle() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_PAGE_TITLE);
        return getElementText(driver, UserRegisterPageUI.REGISTER_PAGE_TITLE);
    }
}

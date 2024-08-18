package pageObjects.nopCommerce.user;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPO extends UserSidebarPO {
    public UserCustomerInfoPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private WebDriver driver;
    @Step("Verify Gender Male radio button is selected")
    public boolean isGenderMaleSelected() {
        waitForElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
        return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
    }
    @Step("Get First Name textbox value")
    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
    }
    @Step("Get Last Name textbox value")
    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
    }
    @Step("Get Company textbox value")
    public String getCompanyTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX, "value");
    }
    @Step("Get Day dropdown value")
    public String getDayDropDownSelectedValue() {
        waitForElementClickable(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
        return getselectItemInDropdown(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
    }
    @Step("Get Month dropdown value")
    public String getMonthDropDownSelectedValue() {
        waitForElementClickable(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
        return getselectItemInDropdown(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
    }
    @Step("Get Year dropdown value")
    public String getyearDropDownSelectedValue() {
        waitForElementClickable(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
        return getselectItemInDropdown(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
    }
    @Step("Get Email textbox value")
    public String getEmailTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

}
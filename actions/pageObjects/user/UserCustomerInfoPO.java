package pageObjects.user;

import org.openqa.selenium.WebDriver;
import pageUIs.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPO extends UserSidebarPO {
    public UserCustomerInfoPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private WebDriver driver;
    public boolean isGenderMaleSelected() {
        waitForElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
        return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
    }
    public String getCompanyTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX, "value");
    }
    public String getDayDropDownSelectedValue() {
        waitForElementClickable(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
        return getselectItemInDropdown(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
    }

    public String getMonthDropDownSelectedValue() {
        waitForElementClickable(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
        return getselectItemInDropdown(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
    }

    public String getyearDropDownSelectedValue() {
        waitForElementClickable(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
        return getselectItemInDropdown(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
    }

    public String getEmailTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

}
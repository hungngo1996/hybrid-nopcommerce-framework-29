package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import org.apache.velocity.runtime.log.NullLogSystem;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.PersonalDetailsPageUI;

public class PersonalDetailsPO extends EmployeeTabs {
    private WebDriver driver;
    public PersonalDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToEmployeeAvatarImage() {
        waitForElementClickable(driver, PersonalDetailsPageUI.EMPLOYEE_IMAGE);
        clickToElement(driver, PersonalDetailsPageUI.EMPLOYEE_IMAGE);
    }

    public void clickToSaveButtonAtChangeProfileContainer() {
        waitForElementClickable(driver, PersonalDetailsPageUI.SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER);
        clickToElement(driver, PersonalDetailsPageUI.SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER);
    }

    public boolean isProfileAvatarUpdateSuccess(Dimension beforeUpload) {
        Dimension afterUpload = getAvatarSize();
        return !(beforeUpload.equals(afterUpload));
    }
    public Dimension getAvatarSize() {
        return getElementSize(driver, PersonalDetailsPageUI.EMPLOYEE_IMAGE);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, PersonalDetailsPageUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(driver,PersonalDetailsPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, PersonalDetailsPageUI.LASTNAME_TEXTBOX);
        sendKeyToElement(driver,PersonalDetailsPageUI.LASTNAME_TEXTBOX, lastName);
    }

    public String getEmployeeID() {
        waitForElementVisible(driver, PersonalDetailsPageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPageUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public void enterToDriverLicenseTextbox(String driverLicenseTextbox) {
        waitForElementVisible(driver, PersonalDetailsPageUI.DRIVER_LICENSE_TEXTBOX);
        sendKeyToElement(driver,PersonalDetailsPageUI.DRIVER_LICENSE_TEXTBOX, driverLicenseTextbox);
    }

    public void enterToLicenseExpiryDateTextbox(String licenseExpiryDateTextbox) {
        waitForElementVisible(driver, PersonalDetailsPageUI.LICENSE_EXPIRY_TEXTBOX);
        sendKeyToElement(driver,PersonalDetailsPageUI.LICENSE_EXPIRY_TEXTBOX, licenseExpiryDateTextbox);
    }

    public void selectNationalityDropdown(String nationality) {
        waitForElementVisible(driver, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_PARENT, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_CHILD, nationality);
    }

    public void selectMaritaStatusDropdown(String matitalStatus) {
        waitForElementVisible(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_PARENT, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_CHILD, matitalStatus);
    }

    public void enterToDateOfBirthTextbox(String dateofbirth) {
        waitForElementVisible(driver, PersonalDetailsPageUI.DATE_OF_BIRTH_TEXTBOX);
        sendKeyToElement(driver, PersonalDetailsPageUI.DATE_OF_BIRTH_TEXTBOX, dateofbirth);
    }

    public void selectGenderMaleRadioButton(String gender) {
        clickToElementByJS(driver, PersonalDetailsPageUI.GENDER_RADIO_BUTTON, gender);
    }

    public void clickSaveButtonAtPersonalDetailContainer() {
        waitForElementVisible(driver, PersonalDetailsPageUI.SAVE_BUTTON_AT_CHANGE_PERSONAL_DETAILS);
        clickToElement(driver, PersonalDetailsPageUI.SAVE_BUTTON_AT_CHANGE_PERSONAL_DETAILS);
    }
    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPageUI.FIRSTNAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPageUI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPageUI.LASTNAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPageUI.LASTNAME_TEXTBOX, "value");
    }

    public String getDriverLicenseTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPageUI.DRIVER_LICENSE_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPageUI.DRIVER_LICENSE_TEXTBOX, "value");
    }

    public String getLicenseExpiryDateTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPageUI.LICENSE_EXPIRY_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPageUI.LICENSE_EXPIRY_TEXTBOX, "value");
    }

    public String getNationalityDropdownValue() {
        waitForElementVisible(driver, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_ITEM_SELECTED);
        return getElementText(driver, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_ITEM_SELECTED);
    }

    public String getMaritaStatusDropdownValue() {
        waitForElementVisible(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_ITEM_SELECTED);
        return getElementText(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_ITEM_SELECTED);
    }

    public String getDateOfBirthTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPageUI.DATE_OF_BIRTH_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPageUI.DATE_OF_BIRTH_TEXTBOX, "value");
    }

    public boolean isGenderMaleRadioSelected(String gender) {
        waitForElementSelected(driver, PersonalDetailsPageUI.GENDER_RADIO_BUTTON, gender);
        return isElementSelected(driver, PersonalDetailsPageUI.GENDER_RADIO_BUTTON, gender);
    }
}

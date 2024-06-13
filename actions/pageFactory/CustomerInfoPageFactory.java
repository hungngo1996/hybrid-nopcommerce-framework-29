package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPageFactory extends BasePage {
    public CustomerInfoPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "gender-male")
    private WebElement genderMaleRadio;
    @FindBy(id = "FirstName")
    private WebElement firstNameTextbox;
    @FindBy(id = "LastName")
    private WebElement lastNameTextbox;
    @FindBy(name = "DateOfBirthDay")
    private WebElement dayDropdown;
    @FindBy(name = "DateOfBirthMonth")
    private WebElement monthDropdown;
    @FindBy(name = "DateOfBirthYear")
    private WebElement yearDropdown;
    @FindBy(id = "Email")
    private WebElement emailTextbox;
    @FindBy(id = "Company")
    private WebElement companyTextbox;
    private WebDriver driver;
    public boolean isGenderMaleSelected() {
        waitForElementSelected(driver, genderMaleRadio);
        return isElementSelected(genderMaleRadio);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, firstNameTextbox);
        return getElementAttribute(firstNameTextbox, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, lastNameTextbox);
        return getElementAttribute(lastNameTextbox, "value");
    }
    public String getCompanyTextboxValue() {
        waitForElementVisible(driver, companyTextbox);
        return getElementAttribute(companyTextbox, "value");
    }
    public String getDayDropDownSelectedValue() {
        waitForElementClickable(driver, dayDropdown);
        return getselectItemInDropdown(dayDropdown);
    }

    public String getMonthDropDownSelectedValue() {
        waitForElementClickable(driver, monthDropdown);
        return getselectItemInDropdown(monthDropdown);
    }

    public String getyearDropDownSelectedValue() {
        waitForElementClickable(driver, yearDropdown);
        return getselectItemInDropdown(yearDropdown);
    }

    public String getEmailTextboxValue() {
        waitForElementVisible(driver, emailTextbox);
        return getElementAttribute(emailTextbox, "value");
    }
}

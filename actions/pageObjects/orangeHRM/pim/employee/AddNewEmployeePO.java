package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.PageGenerator;
import pageUIs.orangeHRM.pim.AddNewPageUI;

public class AddNewEmployeePO extends BasePage {
    private WebDriver driver;
    public AddNewEmployeePO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextbox(String s) {
        waitForElementVisible(driver, AddNewPageUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(driver,AddNewPageUI.FIRSTNAME_TEXTBOX,s);
    }

    public void enterToLastNameTextbox(String s) {
        waitForElementVisible(driver, AddNewPageUI.LASTNAME_TEXTBOX);
        sendKeyToElement(driver,AddNewPageUI.LASTNAME_TEXTBOX,s);
    }

    public String getEmployeeId() {
        waitForElementVisible(driver,AddNewPageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver,AddNewPageUI.EMPLOYEE_ID_TEXTBOX,"value");
    }

    public PersonalDetailsPO clickToSaveButtonAtEmployeeContainer() {
        waitForElementVisible(driver,AddNewPageUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        clickToElement(driver,AddNewPageUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }
}

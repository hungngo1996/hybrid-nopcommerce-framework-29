package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.PageGenerator;
import pageUIs.orangeHRM.DardboardPageUI;
import pageUIs.orangeHRM.pim.EmployeeListPageUI;

public class EmployeeListPO extends BasePage {
    private WebDriver driver;
    public EmployeeListPO(WebDriver driver) {
        this.driver = driver;
    }

    public AddNewEmployeePO clickToAddEmployeeButton() {
        waitForElementClickable(driver, EmployeeListPageUI.ADD_EMPLOYEE_NAV_BUTTON);
        clickToElement(driver, EmployeeListPageUI.ADD_EMPLOYEE_NAV_BUTTON);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getAddNewEmployeePage(driver);
    }
}

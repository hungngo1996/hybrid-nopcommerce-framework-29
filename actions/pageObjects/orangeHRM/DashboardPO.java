package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.pim.employee.EmployeeListPO;
import pageUIs.orangeHRM.DardboardPageUI;

public class DashboardPO extends BasePage {
    private WebDriver driver;

    public DashboardPO(WebDriver driver){
        this.driver = driver;
    }

    public EmployeeListPO clickToPIMPage() {
        waitForElementClickable(driver, DardboardPageUI.PIM_LINK);
        clickToElement(driver,DardboardPageUI.PIM_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getEmployeeListPage(driver);
    }
}

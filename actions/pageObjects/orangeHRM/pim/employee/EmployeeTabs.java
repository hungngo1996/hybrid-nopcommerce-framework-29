package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.orangeHRM.pim.EmployeeTabsUI;

public class EmployeeTabs extends BasePage {
    private WebDriver driver;
    public EmployeeTabs(WebDriver driver) {
        this.driver = driver;
    }
    public PersonalDetailsPO openPersonalDetailPage(){
        waitForElementClickable(driver, EmployeeTabsUI.PERSONAL_DETAIL_LINK);
        clickToElement(driver, EmployeeTabsUI.PERSONAL_DETAIL_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailPage(driver);
    }
    public ContactDetailsPO openContactDetailPage(){
        waitForElementClickable(driver, EmployeeTabsUI.CONTACT_DETAIL_LINK);
        clickToElement(driver, EmployeeTabsUI.CONTACT_DETAIL_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getContactDetailPage(driver);
    }
    public EmergencyContactsPO openEmergencyDetailPage(){
        waitForElementClickable(driver, EmployeeTabsUI.EMERGENCY_CONTACT_LINK);
        clickToElement(driver, EmployeeTabsUI.EMERGENCY_CONTACT_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getEmergencyDetailPage(driver);
    }

}

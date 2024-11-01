package pageObjects.nopCommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.user.UserSideBarPageUI;

public class UserSidebarPO extends BasePage {

    WebDriver driver;
    public UserSidebarPO(WebDriver driver) {
        this.driver = driver;
    }
    public UserAddressPO openAddressPage() {
        waitForElementClickable(driver, UserSideBarPageUI.ADDRESS_LINK);
        clickToElement(driver, UserSideBarPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }

    public UserRewardPointPO openRewardPointPage() {
        waitForElementClickable(driver, UserSideBarPageUI.REWARD_POINT_LINK);
        clickToElement(driver, UserSideBarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewardPointPage(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage() {
        waitForElementClickable(driver, UserSideBarPageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, UserSideBarPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getUserCustomerInfoPage(driver);
    }
    public UserOrderPO openOrderPage() {
        waitForElementClickable(driver, UserSideBarPageUI.ORDER_LINK);
        clickToElement(driver, UserSideBarPageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }
    public void openSidebarLinkByPageNames(String pageName) {
        waitForElementClickable(driver, UserSideBarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        clickToElement(driver, UserSideBarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
    }
}

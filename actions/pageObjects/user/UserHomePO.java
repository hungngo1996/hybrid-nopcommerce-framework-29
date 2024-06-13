package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.user.UserHomePageUI;
import pageUIs.user.UserRegisterPageUI;

public class UserHomePO extends BasePage {
    private WebDriver driver;
    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }
    // Hàm khởi tạo (Constructor function)
    // 1. Cùng tên vs tên class
    // 2. Không có kiểu trả về (Data Type)
    // 3. Sẽ được chạy đầu tiên khi class này được gọi (new HomePageObject)
    // 4. Có tham số hoặc không
    // 5. Trong trường hợp không define hàm khởi tạo thì JVM sẽ tạo ra một hàm khởi tạo rỗng

    public UserRegisterPO openRegisterPage() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
        return PageGenerator.getUserRegisterPage(driver);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    }
    public UserLoginPO openLoginPage() {
        waitForElementVisible(driver, UserRegisterPageUI.LOGIN_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }
    public UserCustomerInfoPO openCustomerInfoPage() {
        waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getUserCustomerInfoPage(driver);
    }
}

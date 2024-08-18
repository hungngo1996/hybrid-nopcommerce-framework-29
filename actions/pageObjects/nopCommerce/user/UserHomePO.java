package pageObjects.nopCommerce.user;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.nopCommerce.user.UserHomePageUI;
import pageUIs.nopCommerce.user.UserRegisterPageUI;

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
    @Step("Open Register Page")
    public UserRegisterPO openRegisterPage() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
        return PageGenerator.getUserRegisterPage(driver);
    }
    @Step("Verify My Account link is displayed")
    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    }
    @Step("Open Login page")
    public UserLoginPO openLoginPage() {
        waitForElementVisible(driver, UserRegisterPageUI.LOGIN_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }
    @Step("Open Customer Info page")
    public UserCustomerInfoPO openCustomerInfoPage() {
        waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getUserCustomerInfoPage(driver);
    }
}

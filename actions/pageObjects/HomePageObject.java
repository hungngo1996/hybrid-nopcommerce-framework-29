package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }
    // Hàm khởi tạo (Constructor function)
    // 1. Cùng tên vs tên class
    // 2. Không có kiểu trả về (Data Type)
    // 3. Sẽ được chạy đầu tiên khi class này được gọi (new HomePageObject)
    // 4. Có tham số hoặc không
    // 5. Trong trường hợp không define hàm khởi tạo thì JVM sẽ tạo ra một hàm khởi tạo rỗng

    public void clickToRegisterLink() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
    }

    public void clickToMyAccountLink() {
        waitForElementVisible(driver,HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
    }
}

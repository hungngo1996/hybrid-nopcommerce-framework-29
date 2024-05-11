package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory extends BasePage {
    private WebDriver driver;
    public HomePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    // Hàm khởi tạo (Constructor function)
    // 1. Cùng tên vs tên class
    // 2. Không có kiểu trả về (Data Type)
    // 3. Sẽ được chạy đầu tiên khi class này được gọi (new HomePageObject)
    // 4. Có tham số hoặc không
    // 5. Trong trường hợp không define hàm khởi tạo thì JVM sẽ tạo ra một hàm khởi tạo rỗng
    @FindBy(className = "ico-register")
    private WebElement registerLink;
    @FindBy(className = "ico-account")
    private WebElement myAccountLink;
    public void clickToRegisterLink() {
        waitForElementClickable(driver, registerLink);
        clickToElement(registerLink);
    }
    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, myAccountLink);
        return isElementDisplayed(myAccountLink);
    }
    public void clickToMyAccountLink() {
        waitForElementVisible(driver,myAccountLink);
        clickToElement(myAccountLink);
    }
}

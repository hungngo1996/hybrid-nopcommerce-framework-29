package pageObjects.saucelabs;
import org.openqa.selenium.WebDriver;

public class SaucelabsPageGenerator {
    public static LoginSaucelabsPO getLoginPage(WebDriver driver){
        return new LoginSaucelabsPO(driver);
    }
    public static InventoryPO getInventoryPage(WebDriver driver){
        return new InventoryPO(driver);
    }
}

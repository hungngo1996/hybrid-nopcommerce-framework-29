package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.user.UserHomePO;

public class PageGenerator {
    public static HomePO getHomePage(WebDriver driver){
        return new HomePO(driver);
    }
}

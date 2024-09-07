package pageObjects.facebook;

import org.openqa.selenium.WebDriver;
import pageObjects.jQuery.HomePO;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.user.*;

public class PageGenerator {
    public static loginPO getLoginPage(WebDriver driver){
        return new loginPO(driver);
    }

}

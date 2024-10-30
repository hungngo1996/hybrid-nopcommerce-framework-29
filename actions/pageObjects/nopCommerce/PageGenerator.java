package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.user.*;
import pageObjects.orangeHRM.pim.employee.ContactDetailsPO;
import pageObjects.orangeHRM.pim.employee.EmergencyContactsPO;
import pageObjects.orangeHRM.pim.employee.PersonalDetailsPO;

public class PageGenerator {
    public static UserHomePO getUserHomePage(WebDriver driver){
        return new UserHomePO(driver);
    }
    public static UserLoginPO getUserLoginPage(WebDriver driver){
        return new UserLoginPO(driver);
    }
    public static UserRegisterPO getUserRegisterPage(WebDriver driver){
        return new UserRegisterPO(driver);
    }
    public static UserCustomerInfoPO getUserCustomerInfoPage(WebDriver driver){
        return new UserCustomerInfoPO(driver);
    }
    public static UserAddressPO getUserAddressPage(WebDriver driver){
        return new UserAddressPO(driver);
    }
    public static UserOrderPO getUserOrderPage(WebDriver driver){
        return new UserOrderPO(driver);
    }
    public static UserRewardPointPO getUserRewardPointPage(WebDriver driver){
        return new UserRewardPointPO(driver);
    }
    public static AdminDashboardPO getAdminDashBoardPage(WebDriver driver){
        return new AdminDashboardPO(driver);
    }
    public static AdminLoginPO getAdminLoginPage(WebDriver driver){
        return new AdminLoginPO(driver);
    }
    public static PersonalDetailsPO getPersonalDetailPage(WebDriver driver){
        return new PersonalDetailsPO(driver);
    }

    public static ContactDetailsPO getContactDetailPage(WebDriver driver) {
        return new ContactDetailsPO(driver);
    }


    public static EmergencyContactsPO getEmergencyDetailPage(WebDriver driver) {
        return new EmergencyContactsPO(driver);
    }
}

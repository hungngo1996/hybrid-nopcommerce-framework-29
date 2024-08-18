package com.nopcommerce.users;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.user.*;
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;
@Feature("User")
public class Level_16_AllureReport extends BaseTest {
    private WebDriver driver;
    private UserHomePO homepage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserRegisterPO registerPage;
    private UserAddressPO addressPage;
    private UserOrderPO orderPage;
    private UserRewardPointPO rewardPointPage;
    private String firstName, lastName, day, month, year, emailAddress, companyName, password;
    private String browserName;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        System.out.println("browserName = " + browserName);
        driver = getBrowserDriver(browserName);
        firstName = "Thomas";
        lastName = "Muller";
        day = "29";
        month = "March";
        year = "1986";
        emailAddress = "thomasmuller" + generateRandomNumber() + "@gmail.com";
        companyName = "Bayern Munich";
        password = "123456789";
        homepage = PageGenerator.getUserHomePage(driver);
        this.browserName = browserName;
    }
    @Description("Register New Account")
    @Test
    public void User_01_Register(Method method) {


        registerPage = homepage.openRegisterPage();

        registerPage.clickToMaleRadio();

        registerPage.enterToFirstNameTextbox(firstName);

        registerPage.enterToLastNameTextbox(lastName);

//        registerPage.selectDayDropdown(day);
//
//        registerPage.selectMonthDropdown(month);
//
//        registerPage.selectYearDropdown(year);

        registerPage.enterToEmailTextbox(emailAddress);

        registerPage.enterToCompanyTextbox(companyName);

        registerPage.enterToPasswordTextbox(password);

        registerPage.enterToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMassage(), "Your registration completed..");
    }
    @Description("Login New Account")
    @Test
    public void User_02_Login() {
        homepage = registerPage.clickToLogoutLink();

        loginPage = homepage.openLoginPage();

        homepage = loginPage.loginToSystem(emailAddress, password);

        Assert.assertTrue(homepage.isMyAccountLinkDisplayed());
    }
    @Description("Verify Account Info")
    @Test
    public void User_03_MyAccount() {
        customerInfoPage = homepage.openCustomerInfoPage();
        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
//        Assert.assertEquals(customerInfoPage.getDayDropDownSelectedValue(),day);
//        Assert.assertEquals(customerInfoPage.getMonthDropDownSelectedValue(),month);
//        Assert.assertEquals(customerInfoPage.getyearDropDownSelectedValue(),year);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);
    }
    // @Test
//    public void User_04_Dynamic_Page() {
//        // Customer Infor > Address
//        customerInfoPage.openSidebarLinkByPageNames("Addresses");
//        addressPage = PageGenerator.getUserAddressPage(driver);
//
//        // Address > Reward Point
//        addressPage.openSidebarLinkByPageNames("Reward points");
//        rewardPointPage = PageGenerator.getUserRewardPointPage(driver);
//
//        // Reward Point > Order
//        rewardPointPage.openSidebarLinkByPageNames("Orders");
//        orderPage = PageGenerator.getUserOrderPage(driver);
//
//        // Order > Address
//        orderPage.openSidebarLinkByPageNames("Addresses");
//        addressPage = PageGenerator.getUserAddressPage(driver);
//
//        // Address > Customer Infor
//        addressPage.openSidebarLinkByPageNames("Customer info");
//        customerInfoPage = PageGenerator.getUserCustomerInfoPage(driver);
//    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}

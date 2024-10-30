package com.nopcommerce.users;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.user.*;
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;

public class Level_15_ExtentReport extends BaseTest {
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
    @Test
    public void User_01_Register(Method method) {

        ExtentManager.startTest(method.getName() + " - " + browserName,"User_01_Register");
        ExtentManager.getTest().log(Status.INFO, "NewCustomer - Step 01: Open 'New Customer' page");

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 01: Open 'Register' page");
        registerPage = homepage.openRegisterPage();

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 02: Click To Maile Radio button");
        registerPage.clickToMaleRadio();

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 03: Enter to 'FirtName' textbox with value" + " " + firstName);
        registerPage.enterToFirstNameTextbox(firstName);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 04: Enter to 'LastName' textbox with value" + " " + lastName);
        registerPage.enterToLastNameTextbox(lastName);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 05: Select 'Day' dropdown with value" + " " + day);
        registerPage.selectDayDropdown(day);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 06: Select 'Month' dropdown with value" + " " + month);
        registerPage.selectMonthDropdown(month);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 07: Select 'Year' dropdown with value" + " " + year);
        registerPage.selectYearDropdown(year);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 08: Enter to 'Email' textbox with value" + " " + emailAddress);
        registerPage.enterToEmailTextbox(emailAddress);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 09: Enter to 'Company' textbox with value" + " " + companyName);
        registerPage.enterToCompanyTextbox(companyName);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 10: Enter to 'Password' textbox with value" + " " + password);
        registerPage.enterToPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 11: Enter to 'Confirm Password' textbox with value" + " " + password);
        registerPage.enterToConfirmPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 12: Click to 'Register' button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 13: Verify 'Register Success Message' visible");
        Assert.assertEquals(registerPage.getRegisterSuccessMassage(), "Your registration completed..");

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - Step 14: Click to 'Logout' link");

    }
    @Test
    public void User_02_Login(Method method) {
        ExtentManager.startTest(method.getName() + " - " + browserName, "User_02_Login");
        homepage = registerPage.clickToLogoutLink();

        loginPage = homepage.openLoginPage();

        homepage = loginPage.loginToSystem(emailAddress, password);

        Assert.assertTrue(homepage.isMyAccountLinkDisplayed());
    }
    @Test
    public void User_03_MyAccount(Method method) {
        ExtentManager.startTest(method.getName() + " - " + browserName, "User_03_MyAccount");
        customerInfoPage = homepage.openCustomerInfoPage();
        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerInfoPage.getDayDropDownSelectedValue(),day);
        Assert.assertEquals(customerInfoPage.getMonthDropDownSelectedValue(),month);
        Assert.assertEquals(customerInfoPage.getyearDropDownSelectedValue(),year);
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

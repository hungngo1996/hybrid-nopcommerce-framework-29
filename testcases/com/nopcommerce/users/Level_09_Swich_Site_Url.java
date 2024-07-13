package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.user.UserCustomerInfoPO;
import pageObjects.nopCommerce.user.UserHomePO;
import pageObjects.nopCommerce.user.UserLoginPO;
import pageObjects.nopCommerce.user.UserRegisterPO;

public class Level_09_Swich_Site_Url extends BaseTest {
    private WebDriver driver;
    private UserHomePO userHomePage;
    private UserLoginPO userLoginPage;
    private UserRegisterPO userRegisterPage;
    private UserCustomerInfoPO userCustomerInfoPage;
    private AdminLoginPO adminLoginPage;
    private AdminDashboardPO adminDashboardPage;
    private String firstName, lastName, day, month, year, emailAddress, companyName, password;
    private String userURL, adminURL;
    private String adminEmailAdress, adminPassword;


    @Parameters({"browser","userURL","adminURL"})
    @BeforeClass
    public void beforeClass(String browserName, String urlUser, String adminURL) {
        this.userURL = urlUser;
        this.adminURL = adminURL;

        driver = getBrowserDriver(browserName, this.userURL);
        userHomePage = PageGenerator.getUserHomePage(driver);

        firstName = "Thomas";
        lastName = "Muller";
        day = "29";
        month = "March";
        year = "1986";
        emailAddress = "thomasmuller" + generateRandomNumber() + "@gmail.com";
        companyName = "Bayern Munich";
        password = "123456789";
        adminEmailAdress = "admin@yourstore.com";
        adminPassword = "admin";
        //Precondition
        // Từ homepage qua registerpage
        userRegisterPage = userHomePage.openRegisterPage();

        userRegisterPage.clickToMaleRadio();
        userRegisterPage.enterToFirstNameTextbox(firstName);
        userRegisterPage.enterToLastNameTextbox(lastName);
        userRegisterPage.selectDayDropdown(day);
        userRegisterPage.selectMonthDropdown(month);
        userRegisterPage.selectYearDropdown(year);
        userRegisterPage.enterToEmailTextbox(emailAddress);
        userRegisterPage.enterToCompanyTextbox(companyName);
        userRegisterPage.enterToPasswordTextbox(password);
        userRegisterPage.enterToConfirmPasswordTextbox(password);
        userRegisterPage.clickToRegisterButton();

        Assert.assertEquals(userRegisterPage.getRegisterSuccessMassage(), "Your registration completed");
        userHomePage = userRegisterPage.clickToLogoutLink();
    }
    @Test
    public void Role_01_User_Site_To_Admin_Site() {
        userLoginPage = userHomePage.openLoginPage();

        userHomePage = userLoginPage.loginToSystem(emailAddress, password);

        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

        //Qua trang Admin
        userHomePage.openPageUrl(driver, this.adminURL);

        // Chua login
        adminLoginPage = PageGenerator.getAdminLoginPage(driver);

        adminLoginPage.enterToEmailTextbox(adminEmailAdress);
        adminLoginPage.enterToPasswordTextbox(adminPassword);
        adminDashboardPage = adminLoginPage.clickToLoginButton();
    }
    @Test
    public void Role_02_Admin_Site_To_User_Site() {

        adminDashboardPage.openPageUrl(driver, this.userURL);
        userHomePage = PageGenerator.getUserHomePage(driver);
        userCustomerInfoPage = userHomePage.openCustomerInfoPage();
        Assert.assertTrue(userCustomerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(userCustomerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(userCustomerInfoPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(userCustomerInfoPage.getDayDropDownSelectedValue(),day);
        Assert.assertEquals(userCustomerInfoPage.getMonthDropDownSelectedValue(),month);
        Assert.assertEquals(userCustomerInfoPage.getyearDropDownSelectedValue(),year);
        Assert.assertEquals(userCustomerInfoPage.getEmailTextboxValue(),emailAddress);


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}

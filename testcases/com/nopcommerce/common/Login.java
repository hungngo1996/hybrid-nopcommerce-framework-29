package com.nopcommerce.common;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import jiraConfigs.JiraCreateIssue;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.user.*;

import java.lang.reflect.Method;
import java.util.Set;

@Feature("User")
public class Login extends BaseTest {
    private WebDriver driver;
    private UserHomePO homepage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserRegisterPO registerPage;
    private UserAddressPO addressPage;
    private UserOrderPO orderPage;
    private UserRewardPointPO rewardPointPage;

    public static String firstName, lastName, emailAddress, companyName, password;

    public static Set<Cookie> nopCommerce;

    @Parameters({"browser", "userURL"})
    @BeforeTest
    public void beforeTest(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homepage = PageGenerator.getUserHomePage(driver);

        // Data-test
        firstName = "Thomas";
        lastName = "Muller";
        emailAddress = "thomasmuller" + generateRandomNumber() + "@gmail.com";
        companyName = "Bayern Munich";
        password = "123456789";

        // New-Account
        registerPage = homepage.openRegisterPage();

        registerPage.clickToRadioByID(driver,"gender-male");

        registerPage.enterToTextboxById(driver, "FirstName", firstName);
        registerPage.enterToTextboxById(driver,"LastName", lastName);
        registerPage.enterToTextboxById(driver,"Email", emailAddress);
        registerPage.enterToTextboxById(driver,"Company", companyName);

        registerPage.clickToCheckboxById(driver, "Newsletter");

        registerPage.enterToTextboxById(driver,"Password", password);
        registerPage.enterToTextboxById(driver,"ConfirmPassword", password);

        registerPage.clickToButtonByText(driver, "Register");

        Assert.assertEquals(registerPage.getRegisterSuccessMassage(), "Your registration completed");

        homepage = registerPage.clickToLogoutLink();

        //Login
        loginPage = homepage.openLoginPage();

        loginPage.enterToTextboxById(driver,"Email", emailAddress);
        loginPage.enterToTextboxById(driver,"Password", password);

        loginPage.clickToButtonByText(driver, "Log in");
        homepage = PageGenerator.getUserHomePage(driver);

        Assert.assertTrue(homepage.isMyAccountLinkDisplayed());
        //Get cookies
        nopCommerce = homepage.getAllCookies(driver);

        driver.quit();
    }
}

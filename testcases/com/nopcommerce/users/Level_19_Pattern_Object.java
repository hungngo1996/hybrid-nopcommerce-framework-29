package com.nopcommerce.users;

import commons.BaseTest;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.user.*;

import java.lang.reflect.Method;

@Feature("User")
public class Level_19_Pattern_Object extends BaseTest {
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

    @Parameters({"browser","userURL"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        System.out.println("browserName = " + browserName);
        driver = getBrowserDriver(browserName, url);
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
    }
    @Test
    public void User_02_Login() {
        homepage = registerPage.clickToLogoutLink();

        loginPage = homepage.openLoginPage();

        loginPage.enterToTextboxById(driver,"Email", emailAddress);
        loginPage.enterToTextboxById(driver,"Password", password);

        loginPage.clickToButtonByText(driver, "Log in");
        homepage = PageGenerator.getUserHomePage(driver);

        Assert.assertTrue(homepage.isMyAccountLinkDisplayed());
    }
    @Test
    public void User_03_MyAccount() {
        customerInfoPage = homepage.openCustomerInfoPage();

        Assert.assertTrue(customerInfoPage.isRadioByIdSelected(driver, "gender-male"));

        Assert.assertEquals(customerInfoPage.getTextboxValueById(driver,"FirstName"),firstName);
        Assert.assertEquals(customerInfoPage.getTextboxValueById(driver,"LastName"),lastName);
        Assert.assertEquals(customerInfoPage.getTextboxValueById(driver,"Email"),emailAddress);
        Assert.assertEquals(customerInfoPage.getTextboxValueById(driver,"Company"),companyName);

        Assert.assertTrue(customerInfoPage.isCheckboxByIdSelected(driver, "Newsletter"));
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}

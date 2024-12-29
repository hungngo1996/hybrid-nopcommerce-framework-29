package com.nopcommerce.users;

import commons.BaseTest;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.user.*;
import utilities.FakerConfig;

import java.lang.reflect.Method;

@Feature("User")
public class Level_24_Data_Faker extends BaseTest {
    private WebDriver driver;
    private UserHomePO homepage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserRegisterPO registerPage;
    private String firstName, lastName, emailAddress, companyName, password;
    private String browserName;
    private FakerConfig faker;

    @Parameters({"browser","userURL"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        System.out.println("browserName = " + browserName);
        driver = getBrowserDriver(browserName, url);
        homepage = PageGenerator.getUserHomePage(driver);
        this.browserName = browserName;
        faker = FakerConfig.getFaker();
        firstName = faker.getFirstName();
        lastName = faker.getLastName();
        emailAddress = faker.getEmail();
        companyName = faker.getCompanyName();
        password = faker.getPassword();
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

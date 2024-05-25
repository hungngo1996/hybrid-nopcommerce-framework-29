package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Level_06_Page_Generator_03 extends BaseTest {
    private WebDriver driver;
    private HomePageObject homepage;
    private LoginPageObject loginPage;
    private CustomerInfoPageObject customerInfoPage;
    private RegisterPageObject registerPage;
    private String firstName, lastName, day, month, year, emailAddress, companyName, password;
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
        homepage = PageGenerator.getHomePage(driver);

    }
    @Test
    public void User_01_Register() {
        // Từ homepage qua registerpage
        registerPage = homepage.openRegisterPage();

        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.selectDayDropdown(day);
        registerPage.selectMonthDropdown(month);
        registerPage.selectYearDropdown(year);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToCompanyTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMassage(), "Your registration completed");
    }
    @Test
    public void User_02_Login() {
        loginPage = registerPage.openLoginPage();

        homepage = loginPage.loginToSystem(emailAddress, password);

        Assert.assertTrue(homepage.isMyAccountLinkDisplayed());
    }
    @Test
    public void User_03_MyAccount() {
        customerInfoPage = homepage.openCustomerInfoPage();

        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerInfoPage.getDayDropDownSelectedValue(),day);
        Assert.assertEquals(customerInfoPage.getMonthDropDownSelectedValue(),month);
        Assert.assertEquals(customerInfoPage.getyearDropDownSelectedValue(),year);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}

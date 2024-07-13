    package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.user.*;

    public class Level_13_Verify extends BaseTest {
        private WebDriver driver;
        private UserHomePO homepage;
        private UserLoginPO loginPage;
        private UserCustomerInfoPO customerInfoPage;
        private UserRegisterPO registerPage;
        private UserAddressPO addressPage;
        private UserOrderPO orderPage;
        private UserRewardPointPO rewardPointPage;
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
            homepage = PageGenerator.getUserHomePage(driver);

        }
        @Test
        public void User_01_Register() {
            // Từ homepage qua registerpage
            registerPage = homepage.openRegisterPage();
            // Assert 01 => Fail
            verifyEquals(registerPage.getRegisterPageTitle(), "REGISTER");

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

            // Assert 02 => Fail
            verifyEquals(registerPage.getRegisterSuccessMassage(), "Your registration completedd");

            homepage = registerPage.clickToLogoutLink();
        }
        @Test
        public void User_02_Login() {
            loginPage = homepage.openLoginPage();

            homepage = loginPage.loginToSystem(emailAddress, password);

            verifyTrue(homepage.isMyAccountLinkDisplayed());
        }
        @Test
        public void User_03_MyAccount() {
            customerInfoPage = homepage.openCustomerInfoPage();

            verifyTrue(customerInfoPage.isGenderMaleSelected());
            verifyEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
            verifyEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
            verifyEquals(customerInfoPage.getDayDropDownSelectedValue(),day);
            verifyEquals(customerInfoPage.getMonthDropDownSelectedValue(),month);
            verifyEquals(customerInfoPage.getyearDropDownSelectedValue(),year);
            verifyEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);

        }

        @AfterClass
        public void afterClass() {
            driver.quit();
        }

    }

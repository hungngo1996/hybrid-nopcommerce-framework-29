package com.nopcommerce.users;

import com.nopcommerce.common.Login;
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

@Feature("User")
public class Level_21_Browser_Config extends BaseTest {
    private WebDriver driver;
    private UserHomePO homepage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserRegisterPO registerPage;
    private UserAddressPO addressPage;
    private UserOrderPO orderPage;
    private UserRewardPointPO rewardPointPage;
    private String firstName, lastName, day, month, year, emailAddress, companyName, password;

    @Parameters({"browser","userURL"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
    }
    @Test
    public void User_01_MyAccount() {

    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //closeBrowserDriver();
    }

}

package facebooks;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.PageGenerator;
import pageObjects.facebook.loginPO;
import pageObjects.nopCommerce.user.*;

import java.lang.reflect.Method;

public class Level_18_Undisplayed extends BaseTest {
    private WebDriver driver;
    private loginPO loginPage;
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGenerator.getLoginPage(driver);

        loginPage.clickToNewAccountButton();
    }
    @Test
    public void TC_01_ElementUndisplayed() {
        loginPage.enterToEmailAddressTextbox("hung@gmail.com");

        // Case 1 - Verify confirm email textbox isdisplayed
        Assert.assertTrue(loginPage.confirmEmailTextboxdisplayed());

        // Case 2 - Verify confirm email textbox undisplayed
        loginPage.enterToEmailAddressTextbox("");
        Assert.assertTrue(loginPage.confirmEmailTextboxUndisplayed());
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}

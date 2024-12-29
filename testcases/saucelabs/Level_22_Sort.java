package saucelabs;

import commons.BaseTest;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.saucelabs.InventoryPO;
import pageObjects.saucelabs.LoginSaucelabsPO;
import pageObjects.saucelabs.SaucelabsPageGenerator;

@Feature("User")
public class Level_22_Sort extends BaseTest {
    private WebDriver driver;
    private LoginSaucelabsPO loginSaucelabsPage;
    private InventoryPO inventoryPage;
    @Parameters({"browser","userURL"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginSaucelabsPage = SaucelabsPageGenerator.getLoginPage(driver);
        inventoryPage = loginSaucelabsPage.loginToApplication("standard_user","secret_sauce");
    }
    @Test
    public void Sort_01_Name() {
        inventoryPage.selectSortDropdown("Name (A to Z)");
        verifyTrue(inventoryPage.isNameSortAscending());

        inventoryPage.selectSortDropdown("Name (Z to A)");
        verifyTrue(inventoryPage.isNameSortDescending());
    }
    @Test
    public void Sort_02_Price() {
        inventoryPage.selectSortDropdown("Price (low to high)");
        verifyTrue(inventoryPage.isPriceSortAscending());
        inventoryPage.selectSortDropdown("Price (high to low)");
        verifyTrue(inventoryPage.isPriceSortDescending());
    }
    @Test
    public void Sort_03_Date() {

    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}

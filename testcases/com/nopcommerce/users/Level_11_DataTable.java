package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.HomePO;
import pageObjects.jQuery.PageGenerator;


public class Level_11_DataTable extends BaseTest {
    private WebDriver driver;
    private HomePO homePage;
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);
    }
    @Test
    public void Table_01() {
        //Navigate to any page (paging)
        homePage.openPageByNumber("12");
        Assert.assertTrue(homePage.isPageNumberActived("12"));

        homePage.openPageByNumber("3");
        Assert.assertTrue(homePage.isPageNumberActived("3"));

        homePage.openPageByNumber("20");
        Assert.assertTrue(homePage.isPageNumberActived("20"));
    }
    @Test
    public void Table_02_Search() {
        //Enter value to header textbox
        homePage.enterToTextboxByHeaderName("Country",  "AFRICA");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isRowDataValueDisplayed("12253515","AFRICA","12599691","24853148"));
        homePage.Refresh(driver);

        homePage.enterToTextboxByHeaderName("Males", "25266");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isRowDataValueDisplayed("24128","Albania","25266","49397"));
        homePage.Refresh(driver);

        homePage.enterToTextboxByHeaderName("Females", "777");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isRowDataValueDisplayed("777","Antigua and Barbuda","803","1580"));
        homePage.Refresh(driver);
        //Verify data in any row

    }
    @Test
    public void Table_03_Delete() {
        //Click delete button
        homePage.enterToTextboxByHeaderName("Country",  "AFRICA");
        homePage.sleepInSecond(2);
        homePage.deleteRowByCountryName("AFRICA");
        homePage.Refresh(driver);

        homePage.enterToTextboxByHeaderName("Country",  "Albania");
        homePage.sleepInSecond(2);
        homePage.deleteRowByCountryName("Albania");
        homePage.Refresh(driver);
    }
    @Test
    public void Table_04_Edit() {
        //Click edit button
        homePage.enterToTextboxByHeaderName("Country",  "Angola");
        homePage.sleepInSecond(2);
        homePage.editRowByCountryName("Angola");
        homePage.Refresh(driver);
    }
    @Test
    public void Table_05_Get_All_Row_Or_Column() {
        homePage.getAllValueAtColumnName("Country");
    }
    @Test
    public void Table_06_Action_By_Index() {
        //Có thể thao tác vs bất kì row nào
        homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        homePage.clickToLoadDataButon();
        homePage.sleepInSecond(2);
        homePage.enterToTextboxByIndex("4", "Contact Person", "Automation");
        homePage.sleepInSecond(2);
        homePage.enterToTextboxByIndex("2", "Company", "Automation FC");
        homePage.sleepInSecond(2);
        homePage.selectToDropDownByIndex("6","Country","Hong Kong");
        homePage.sleepInSecond(2);
        homePage.selectToDropDownByIndex("8","Country","United Kingdom");
        homePage.sleepInSecond(2);
        homePage.checkToCheckboxByIndex("6","NPO?", true);
        homePage.sleepInSecond(2);
        homePage.checkToCheckboxByIndex("5","NPO?", false);
        homePage.sleepInSecond(2);
        // Sau mỗi sự kiện đã thao tác thì index của từng row sẽ được cập nhật lại
        homePage.clickToIconByIndex("8","Move Up");
        homePage.clickToIconByIndex("6","Remove");
        homePage.clickToIconByIndex("4","Insert");
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}

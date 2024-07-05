package jQuery.cases;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.HomePO;
import pageObjects.jQuery.PageGenerator;


public class Level_12_UpLoad extends BaseTest {
    private WebDriver driver;
    private HomePO homePage;
    private String cmhue,cmhn,cmhcm;
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);

        homePage = PageGenerator.getHomePage(driver);
        cmhcm = "ChaoMaoHCM.jfif";
        cmhue = "ChaoMaoHue.jpg";
        cmhn = "ChaoMaoHN.jfif";
    }
    @Test
    public void Upload_01() {
        //Lay ra duoc duong dan cua file/ thu muc cho dung cho all OS

        //Co the upload 1 lan 1 file
//        homePage.uploadMultipleFiles(driver, cmhcm);
//        homePage.sleepInSecond(3);
//        homePage.Refresh(driver);
        //Co the upload 1 lan nhieu file
        homePage.uploadMultipleFiles(driver, cmhcm, cmhue, cmhn);
        homePage.sleepInSecond(3);

        //Co the verify 1 file/nhieu file
        Assert.assertTrue(homePage.isFileLoadedByName(cmhcm));
        Assert.assertTrue(homePage.isFileLoadedByName(cmhue));
        Assert.assertTrue(homePage.isFileLoadedByName(cmhn));

        homePage.clickToUploadButton(driver);

        Assert.assertTrue(homePage.isFileUploadedByName(cmhue));
        Assert.assertTrue(homePage.isFileUploadedByName(cmhcm));
        Assert.assertTrue(homePage.isFileUploadedByName(cmhn));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}

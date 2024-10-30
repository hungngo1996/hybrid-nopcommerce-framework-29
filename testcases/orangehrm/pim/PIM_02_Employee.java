package orangehrm.pim;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PIM_02_Employee extends BaseTest {
    private WebDriver driver;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
    }


    @Test
    public void Employee_07_Edit_View_Job() {

    }

    @Test
    public void Employee_08_Edit_View_Salary() {

    }

    @Test
    public void Employee_09_Edit_View_Tax() {

    }

    @Test
    public void Employee_10_Qualifications() {

    }

    @Test
    public void Employee_11_Search_Employee() {

    }

    @Test
    public void Employee_12_Immigration() {

    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}

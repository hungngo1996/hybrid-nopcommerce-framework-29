package orangehrm;

import commons.BaseTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangeHRM.DashboardPO;
import pageObjects.orangeHRM.LoginPO;
import pageObjects.orangeHRM.PageGenerator;
import pageObjects.orangeHRM.pim.employee.AddNewEmployeePO;
import pageObjects.orangeHRM.pim.employee.EmployeeListPO;
import pageObjects.orangeHRM.pim.employee.PersonalDetailsPO;

public class Level_23_Live_Code extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;
    private AddNewEmployeePO addNewEmployeePage;
    private String employeeId, firstName, lastName, editFirstName, editLastName;
    private String driverLicenseNumber, driverLicenseExpiryDate, nationality, maritalStatus, dateofBirth, gender;
    private String avatarImageName = "ChaoMaoHue.jpg";

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        firstName = "Lycan";
        lastName = "ThrowW";
        editFirstName = "Donal";
        editLastName = "Trump";
        driverLicenseNumber = "03499843";
        driverLicenseExpiryDate = "2030-01-02";
        nationality = "American";
        maritalStatus = "Married";
        dateofBirth = "1995-01-02";
        gender = "Male";
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.enterToUsernameTextbox("automation");
        loginPage.enterToPasswordTextbox("Ken@0543600932");
        dashboardPage = loginPage.clickToLoginButton();
    }

    @Test
    public void Employee_01_Add_New() {
        employeeListPage = dashboardPage.clickToPIMPage();
        addNewEmployeePage = employeeListPage.clickToAddEmployeeButton();
        addNewEmployeePage.enterToFirstNameTextbox(firstName);
        addNewEmployeePage.enterToLastNameTextbox(lastName);
        employeeId = addNewEmployeePage.getEmployeeId();
        personalDetailsPage = addNewEmployeePage.clickToSaveButtonAtEmployeeContainer();
    }

    @Test
    public void Employee_02_Upload_Avatar() {
        personalDetailsPage.clickToEmployeeAvatarImage();
        Dimension beforeUpload = personalDetailsPage.getAvatarSize();
        personalDetailsPage.uploadMultipleFiles(driver, avatarImageName);
        personalDetailsPage.clickToSaveButtonAtChangeProfileContainer();
        Assert.assertTrue(personalDetailsPage.isSuccessMessageIsDisplayed(driver));
        personalDetailsPage.waitAllLoadingIconInvisible(driver);
        Assert.assertFalse(personalDetailsPage.isProfileAvatarUpdateSuccess(beforeUpload));
    }

    @Test
    public void Employee_03_Personal_Details() {
        personalDetailsPage.openPersonalDetailPage();

        personalDetailsPage.enterToFirstNameTextbox(editFirstName);
        personalDetailsPage.enterToLastNameTextbox(editLastName);

        Assert.assertEquals(personalDetailsPage.getEmployeeID(), employeeId);

        personalDetailsPage.enterToDriverLicenseTextbox(driverLicenseNumber);
        personalDetailsPage.enterToLicenseExpiryDateTextbox(driverLicenseExpiryDate);
        personalDetailsPage.selectNationalityDropdown(nationality);
        personalDetailsPage.selectMaritaStatusDropdown(maritalStatus);

        personalDetailsPage.enterToDateOfBirthTextbox(dateofBirth);
        personalDetailsPage.selectGenderMaleRadioButton(gender);
        personalDetailsPage.clickSaveButtonAtPersonalDetailContainer();

        Assert.assertTrue(personalDetailsPage.isSuccessMessageIsDisplayed(driver));

        // Verify
        Assert.assertEquals(personalDetailsPage.getFirstNameTextboxValue(),editFirstName);
        Assert.assertEquals(personalDetailsPage.getLastNameTextboxValue(),editLastName);
        Assert.assertEquals(personalDetailsPage.getEmployeeID(),employeeId);
        Assert.assertEquals(personalDetailsPage.getDriverLicenseTextboxValue(),driverLicenseNumber);
        Assert.assertEquals(personalDetailsPage.getLicenseExpiryDateTextboxValue(),driverLicenseExpiryDate);
        Assert.assertEquals(personalDetailsPage.getNationalityDropdownValue(),nationality);
        Assert.assertEquals(personalDetailsPage.getMaritaStatusDropdownValue(),maritalStatus);
        Assert.assertEquals(personalDetailsPage.getDateOfBirthTextboxValue(),dateofBirth);
        Assert.assertTrue(personalDetailsPage.isGenderMaleRadioSelected("Male"));
    }

    @Test
    public void Employee_04_Contact_Details() {

    }

    @Test
    public void Employee_05_Emergency_Details() {

    }

    @Test
    public void Employee_06_Assigned_Dependents() {

    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}

package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_III_Inheritance extends BasePage {
    private WebDriver driver;
    private String firstName, lastName, day, month, year, emailAddress, companyName, passWord;
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        firstName = "Thomas";
        lastName = "Muller";
        day = "10";
        month = "August";
        year = "1986";
        emailAddress = "thomasmuller" + generateRandomNumber() + "@gmail.com" ;
        companyName = "Bayern Munich";
        passWord = "123456789";
    }
    @Test
    public void TC_01_Register(){
         waitForElementClickable(driver, "//a[@class='ico-register']");
         clickToElement(driver, "//a[@class='ico-register']");

         waitForElementClickable(driver, "//input[@id='gender-male']");
         clickToElement(driver, "//input[@id='gender-male']");

         sendKeyToElement(driver,"//input[@id='FirstName']",firstName);
         sendKeyToElement(driver,"//input[@id='LastName']",lastName);

         selectItemInDropdown(driver,"//select[@name='DateOfBirthDay']",day);
         selectItemInDropdown(driver,"//select[@name='DateOfBirthMonth']",month);
         selectItemInDropdown(driver,"//select[@name='DateOfBirthYear']",year);

         sendKeyToElement(driver, "//input[@id='Email']",emailAddress);
         sendKeyToElement(driver, "//input[@id='Company']",companyName);
         sendKeyToElement(driver, "//input[@id='Password']",passWord);
         sendKeyToElement(driver, "//input[@id='ConfirmPassword']",passWord);

         waitForElementClickable(driver,"//button[@id='register-button']");

         clickToElement(driver, "//button[@id='register-button']");

         Assert.assertEquals(getElementText(driver,"//div[@class='result']"),"Your registration completed");
    }
    @Test
    public void TC_02_Login(){
         waitForElementClickable(driver,"//a[@class='ico-login']");
         clickToElement(driver, "//a[@class='ico-login']");
         sendKeyToElement(driver,"//input[@id='Email']",emailAddress);
         sendKeyToElement(driver,"//input[@id='Password']",passWord);
         waitForElementClickable(driver,"//button[contains(@class,'login-button')]");
         clickToElement(driver, "//button[contains(@class,'login-button')]");
         Assert.assertTrue( isElementDisplayed(driver,"//a[@class='ico-account' and text()='My account']"));
    }

    @Test
    public void TC_03_MyAccount(){
        waitForElementClickable(driver,"//a[@class='ico-account']");
        clickToElement(driver,"//a[@class='ico-account']");
        Assert.assertTrue( isElementSelected(driver, "//input[@id='gender-male']"));
        Assert.assertEquals( getElementAttribute(driver, "//input[@id='FirstName']","value"),firstName);
        Assert.assertEquals( getElementAttribute(driver, "//input[@id='LastName']","value"),lastName);

        Assert.assertEquals( getselectItemInDropdown(driver, "//select[@name='DateOfBirthDay']"),day);
        Assert.assertEquals( getselectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']"),month);
        Assert.assertEquals( getselectItemInDropdown(driver, "//select[@name='DateOfBirthYear']"),year);

        Assert.assertEquals( getElementAttribute(driver, "//input[@id='Company']","value"),companyName);
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
    private int generateRandomNumber(){
        return new Random().nextInt(99999);
    }
}

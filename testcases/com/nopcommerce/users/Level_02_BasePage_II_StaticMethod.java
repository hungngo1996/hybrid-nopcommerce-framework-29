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

public class Level_02_BasePage_II_StaticMethod {
    private WebDriver driver;
    private String firstName, lastName, day, month, year, emailAddress, companyName, passWord;
    BasePage basePage;
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        firstName = "Thomas";
        lastName = "Muller";
        day = "10";
        month = "August";
        year = "1986";
        emailAddress = "thomasmuller" + generateRandomNumber() + "@gmail.com" ;
        companyName = "Bayern Munich";
        passWord = "123456789";
        basePage = BasePage.getBasePage();
    }
    @Test
    public void TC_01_Register(){
        basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.waitForElementClickable(driver, "//input[@id='gender-male']");
        basePage.clickToElement(driver, "//input[@id='gender-male']");

        basePage.sendKeyToElement(driver,"//input[@id='FirstName']",firstName);
        basePage.sendKeyToElement(driver,"//input[@id='LastName']",lastName);

        basePage.selectItemInDropdown(driver,"//select[@name='DateOfBirthDay']",day);
        basePage.selectItemInDropdown(driver,"//select[@name='DateOfBirthMonth']",month);
        basePage.selectItemInDropdown(driver,"//select[@name='DateOfBirthYear']",year);

        basePage.sendKeyToElement(driver, "//input[@id='Email']",emailAddress);
        basePage.sendKeyToElement(driver, "//input[@id='Company']",companyName);
        basePage.sendKeyToElement(driver, "//input[@id='Password']",passWord);
        basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']",passWord);

        basePage.waitForElementClickable(driver,"//button[@id='register-button']");

        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='result']"),"Your registration completed");
    }
    @Test
    public void TC_02_Login(){
        basePage.waitForElementClickable(driver,"//a[@class='ico-login']");
        basePage.clickToElement(driver, "//a[@class='ico-login']");

        basePage.sendKeyToElement(driver,"//input[@id='Email']",emailAddress);
        basePage.sendKeyToElement(driver,"//input[@id='Password']",passWord);

        basePage.waitForElementClickable(driver,"//button[contains(@class,'login-button')]");
        basePage.clickToElement(driver, "//button[contains(@class,'login-button')]");
        Assert.assertTrue(basePage.isElementDisplayed(driver,"//a[@class='ico-account' and text()='My account']"));
    }

    @Test
    public void TC_03_MyAccount(){
        basePage.waitForElementClickable(driver,"//a[@class='ico-account']");
        basePage.clickToElement(driver,"//a[@class='ico-account']");
        Assert.assertTrue(basePage.isElementSelected(driver, "//input[@id='gender-male']"));
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='FirstName']","value"),firstName);
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='LastName']","value"),lastName);

        Assert.assertEquals(basePage.getselectItemInDropdown(driver, "//select[@name='DateOfBirthDay']"),day);
        Assert.assertEquals(basePage.getselectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']"),month);
        Assert.assertEquals(basePage.getselectItemInDropdown(driver, "//select[@name='DateOfBirthYear']"),year);

        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='Company']","value"),companyName);
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
    private int generateRandomNumber(){
        return new Random().nextInt(99999);
    }
}

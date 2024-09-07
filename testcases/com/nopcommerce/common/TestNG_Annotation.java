package com.nopcommerce.common;

import org.junit.After;
import org.testng.annotations.*;

public class TestNG_Annotation {
    @BeforeTest
    public void beforeTest(){
        System.out.println("Run Before Test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("Run After Test");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Run Before Method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Run After Method");
    }
    @Test
    public void TC_01(){
        System.out.println("TC_01");
    }
    @Test
    public void TC_02(){
        System.out.println("TC_02");
    }
}

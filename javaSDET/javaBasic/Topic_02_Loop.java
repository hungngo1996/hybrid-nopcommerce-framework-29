package javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.NoSuchElementException;

public final class Topic_02_Loop {// final: không cho các class khác kế thừa
    // Final: không cho phép gán giá trị mới
    public static final String PI = "3.143243434546";
    // class không cho phép overide
    public final void clickToElement() throws InterruptedException {
        Thread.sleep(5000);
    }
    public static void clickToButton(){

    }
    public static void main(String[] args) throws InterruptedException {
        Topic_02_Loop topic02 = new Topic_02_Loop();
        topic02.clickToElement();
        Topic_02_Loop.clickToButton();
        System.out.println(Topic_02_Loop.PI);
        for (int i = 1; i <= 10; i++){
            System.out.println(i);
        }
        int i = 1;
        while (i <= 10){
            System.out.println(i);
            i++;
        }

        i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 10);

    }
    public boolean isElementDisplayed() {
        WebDriver driver = new FirefoxDriver();
        WebElement element = driver.findElement(By.cssSelector(""));
        boolean status = false;
        try {
            element.isDisplayed();
        }catch (NoSuchElementException e){
            throw new RuntimeException(e.getMessage());
        } finally { // Step bắt buộc phải chạy
            //...
        }
        return status;
    }
}

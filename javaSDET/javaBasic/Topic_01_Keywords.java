package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_01_Keywords {
    // Có các hàm non-abstract
    public void clickToElement(){
        // có phần thân hàm
    }
    // không được chưa các hàm abstract
    public void clickToElement_2(){

    }
    // Nguyên Thủy (Primitive Type)
    char c = 'a';
    byte bNumber = 10;
    short sNumber = 100;
    int iNumber = 1000;
    long lNumber = 10000;
    float fNumber = 15.7f;
    double dNumber = 45.5d;
    boolean bStatus = true;

    // Tham chiếu (Reference Type)
    String fullName = "Automation Test";
    // Hàm không cần trả về
    void clickToElement_3(){

    }
    // Hàm cần trả về kiểu String
    String getLoginMessage(){
        return "";
    }
    // Bất kì 1 class nào cũng truy cập vào biến này được
    public String address = "145 ABC";
    // Thằng nào kế thừa class define biến này sẽ dùng được
    protected String city = "TP HUE";
    // Chỉ class này dùng được
    private String Phone = "0349384";
    // Trong cùng package dùng được
    String zipCode = "34847";

    // package: define class hay inerface nằm trong package nào
    // Biểu thức điều kiện
    WebDriver driver;
    public WebDriver getBrowserDriver(String BrowserName){
        if (BrowserName.equals("firefox")){
            driver = new FirefoxDriver();
        } else if (BrowserName.equals("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new EdgeDriver();
        }



        switch (BrowserName){
            case "firefox":
                driver = new FirefoxDriver();
            case "chrome":
                driver = new ChromeDriver();
            default:
                driver = new EdgeDriver();
        }
        return driver;
    }
}

package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Locale;
import java.util.Random;

public class BaseTest {
    private WebDriver driver;
    protected int generateRandomNumber() {
        return new Random().nextInt(99999);
    }
    protected WebDriver getBrowserDriver(String browserName){
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        switch (browser){
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;
    }
}

package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Random;

public class BaseTest {
    public WebDriver getDriver() {
        return driver;
    }
    private WebDriver driver;
    protected final Logger log;
    protected BaseTest() {
        log = LogManager.getLogger(getClass());
    }
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
        driver.get(GlobalConstants.DEV_USER_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIME));
        driver.manage().window().maximize();
        return driver;
    }
    protected WebDriver getBrowserDriver(String browserName, String url){
//        Path path = null;
//        File extensionFilePath = null;
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        switch (browser){
            case FIREFOX:
                driver = new FirefoxDriver();
//                Path xpiPath = Paths.get(GlobalConstants.BROWSER_EXTENSION_PATH + "Wappalyzer.xpi");
//                FirefoxDriver ffDriver = (FirefoxDriver) driver;
//                ffDriver.installExtension(xpiPath);
//                driver = ffDriver;
                break;
            case EDGE:
                EdgeOptions eOptions = new EdgeOptions();
//                path = Paths.get(GlobalConstants.BROWSER_EXTENSION_PATH + "Wappalyzer.crx");
//                extensionFilePath = new File(path.toUri());
//                eOptions.addExtensions(extensionFilePath);
                driver = new EdgeDriver(eOptions);
                break;
            case CHROME:
                ChromeOptions cOptions = new ChromeOptions();
//                path = Paths.get(GlobalConstants.BROWSER_EXTENSION_PATH + "Wappalyzer.crx");
//                extensionFilePath = new File(path.toUri());
//                cOptions.addExtensions(extensionFilePath);
                cOptions.addArguments("--user-data-dir=C:\\Users\\Hung Ngo\\AppData\\Local\\Google\\Chrome\\User Data\\");
                cOptions.addArguments("--profile-directory=Profile 2");
                driver = new ChromeDriver(cOptions);
                break;
            case HCHROME:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("-headless");
                options.addArguments("window-size=1920x1080");
                driver = new ChromeDriver(options);
                break;
            case HFIREFOX:
                FirefoxOptions chromeOptions = new FirefoxOptions();
                chromeOptions.addArguments("-headless");
                chromeOptions.addArguments("window-size=1920x1080");
                driver = new FirefoxDriver(chromeOptions);
                break;
            case HEDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("-headless");
                edgeOptions.addArguments("window-size=1920x1080");
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIME));
        driver.manage().window().maximize();
        return driver;
    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
    @BeforeSuite
    public void deleteFileInReport() {
        // Remove all file in ReportNG screenshot (image)
        deleteAllFileInFolder("htmlReportNG");

        // Remove all file in Allure attachment (json file)
         deleteAllFileInFolder("allure-results");
    }
    private void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.PROJECT_PATH + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

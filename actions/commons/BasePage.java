package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AddressPageObject;
import pageObjects.OrderPageObject;
import pageObjects.PageGenerator;
import pageObjects.RewardPointPageObject;
import pageUIs.AddressPageUI;
import pageUIs.BasePageUI;
import pageUIs.CustomerInfoPageUI;
import pageUIs.RewordPointPageUI;

import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class BasePage {
    public static BasePage getBasePage(){
        return new BasePage();
    }
    String pageUrl = "https://demo.nopcommerce.com/";
    public void openPageUrl(WebDriver driver, String pageUrl){
        driver.get(pageUrl);
    }
    public String getPageTitle(WebDriver driver){
        return driver.getTitle();
    }
    public String getPageUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }
    public String getPageSource(WebDriver driver){
        return driver.getPageSource();
    }
    public void backToPage(WebDriver driver){
        driver.navigate().back();
    }
    public void forwardToPage(WebDriver driver){
        driver.navigate().forward();
    }
    public void Refresh(WebDriver driver){
        driver.navigate().refresh();
    }
    public Alert waitAlertPresence(WebDriver driver){
         return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
    }
    public void acceptToAlert(WebDriver driver){
        waitAlertPresence(driver).accept();
    }
    public void cancelToAlert(WebDriver driver){
        waitAlertPresence(driver).dismiss();
    }
    public String getAlertText(WebDriver driver){
        return waitAlertPresence(driver).getText();
    }
    public void sendkeyToAlert(WebDriver driver, String keysToSend){
        waitAlertPresence(driver).sendKeys(keysToSend);
    }
    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }
    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }
    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }
    public WebElement getElement(WebDriver driver, String locator){
        return driver.findElement(By.xpath(locator));
    }
    public List<WebElement> getListElement(WebDriver driver, String locator){
        return driver.findElements(By.xpath(locator));
    }
    public By getByXpath(String locator){
        return By.xpath(locator);
    }
    public void clickToElement(WebDriver driver, String locator){
        getElement(driver, locator).click();
    }
    public void sendKeyToElement(WebDriver driver, String locator, String keysToSend){
        getElement(driver, locator).sendKeys(keysToSend);
    }
    public void selectItemInDropdown(WebDriver driver, String locator, String textItem){
        new Select(getElement(driver, locator)).selectByVisibleText(textItem);
    }
    public String getselectItemInDropdown(WebDriver driver, String locator){
        return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
    }
    public boolean isDropdownMultiple(WebDriver driver, String locator){
        return new Select(getElement(driver, locator)).isMultiple();
    }
    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        sleepInSecond(2);

        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemLocator)));
        sleepInSecond(2);
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {

                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }
    public String getElementAttribute(WebDriver driver, String locator, String attributeName)
    {
        return getElement(driver,locator).getAttribute(attributeName);
    }
    public String getElementText(WebDriver driver, String locator)
    {
        return getElement(driver,locator).getText();
    }
    public void getElementCssValue(WebDriver driver, String locator, String propertyName){
        getElement(driver, locator).getCssValue(propertyName);
    }
    public String  getHexaColorFromRBGA(String rbgaValue){
        return Color.fromString(rbgaValue).asHex().toUpperCase();
    }
    public int getListElementNumber(WebDriver driver, String locator){
        return getListElement(driver, locator).size();
    }
    public void checkToCheckboxRadio(WebDriver driver, String locator){
        if (!getElement(driver, locator).isSelected())
        {
            getElement(driver, locator).click();
        }
    }
    public void unCheckToCheckboxRadio(WebDriver driver, String locator){
        if (getElement(driver, locator).isSelected())
        {
            getElement(driver, locator).click();
        }
    }
    public boolean isElementDisplayed(WebDriver driver, String locator){
        return getElement(driver,locator).isDisplayed();
    }
    public boolean isElementEnabled(WebDriver driver, String locator){
        return getElement(driver,locator).isEnabled();
    }
    public boolean isElementSelected(WebDriver driver, String locator){
        return getElement(driver,locator).isSelected();
    }
    public void switchToIFrame(WebDriver driver, String locator){
        driver.switchTo().frame(getElement(driver,locator));
    }
    public void switchToDefaultPage(WebDriver driver){
        driver.switchTo().defaultContent();
    }
    public void holdToElement(WebDriver driver, String locator){
        new Actions(driver).moveToElement(getElement(driver, locator)).perform();
    }
    public void clickToElementByAction(WebDriver driver, String locator){
        new Actions(driver).click(getElement(driver, locator)).perform();
    }
    public void clickAndHoldToElement(WebDriver driver, String locator){
        new Actions(driver).clickAndHold(getElement(driver, locator)).perform();
    }
    public void releaseLeftMouse(WebDriver driver){
        new Actions(driver).release();
    }
    public void doubleClickToElement(WebDriver driver, String locator){
        new Actions(driver).doubleClick(getElement(driver, locator)).perform();
    }
    public void rightClickToElement(WebDriver driver, String locator){
        new Actions(driver).contextClick(getElement(driver, locator)).perform();
    }
    public void dragAndDropToElement(WebDriver driver, String sourcelocator, String targetLocator){
        new Actions(driver).dragAndDrop(getElement(driver, sourcelocator),getElement(driver, targetLocator)).perform();
    }
    public void pressKeyToElement(WebDriver driver, String locator, Keys keys){
        new Actions(driver).sendKeys(getElement(driver, locator),keys).perform();
    }
    public void scrollToElement(WebDriver driver, String locator, Keys keys){
        new Actions(driver).sendKeys(getElement(driver, locator),keys).perform();
    }

    public void scrollToBottomPageByJs(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void hightlightElement(String locator, WebDriver driver) {
        String originalStyle = getElement(driver, locator).getAttribute("style");
        String JS = (String) ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", getElement(driver, locator), "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", getElement(driver, locator), originalStyle);
    }

    public void clickToElementByJS(String locator, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
        sleepInSecond(3);
    }

    public void scrollToElementOnTopByJS(String locator, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnDown(String locator, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public void setAttributeInDOM(String locator, String attributeName, String attributeValue, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(driver, locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public void sendkeyToElementByJS(String locator, String value, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public String getAttributeInDOMByJS(String locator, String attributeName, WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }

    public String getElementValidationMessage(String locator, WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(String locator, WebDriver driver) {
        boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(driver, locator));
        return status;
    }

    public void  waitForElementVisible(WebDriver driver, String locator){
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }
    public void  waitForElementPresence(WebDriver driver, String locator){
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(getByXpath(locator)));
    }
    public void  waitForElementInvisible(WebDriver driver, String locator){
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
    }
    public void  waitForElementSelected(WebDriver driver, String locator){
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeSelected(getByXpath(locator)));
    }
    public void  waitForElementClickable(WebDriver driver, String locator){
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }
    public AddressPageObject openAddressPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.ADDRESS_LINK);
        clickToElement(driver, BasePageUI.ADDRESS_LINK);
        return PageGenerator.getAddressPage(driver);
    }

    public RewardPointPageObject openRewardPointPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.REWARD_POINT_LINK);
        clickToElement(driver, BasePageUI.REWARD_POINT_LINK);
        return PageGenerator.getRewardPointPage(driver);
    }

    public OrderPageObject openCustomerInfoPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, BasePageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getOrderPage(driver);
    }
    public OrderPageObject openOrderPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.ORDER_LINK);
        clickToElement(driver, BasePageUI.ORDER_LINK);
        return PageGenerator.getOrderPage(driver);
    }

    public void sleepInSecond(long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

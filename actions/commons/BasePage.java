package commons;

import io.reactivex.rxjava3.flowables.GroupedFlowable;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.user.UserAddressPO;
import pageObjects.nopCommerce.user.UserCustomerInfoPO;
import pageObjects.nopCommerce.user.UserOrderPO;
import pageObjects.nopCommerce.user.UserRewardPointPO;
import pageObjects.orangeHRM.pim.employee.PersonalDetailsPO;
import pageUIs.jQuery.HomePageUI;
import pageUIs.nopCommerce.BasePageUI;
import pageUIs.orangeHRM.pim.PersonalDetailsPageUI;

import java.security.Key;
import java.time.Duration;
import java.util.List;
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
         return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME)).until(ExpectedConditions.alertIsPresent());
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
        return driver.findElement(getByLocator(locator));
    }
    public Dimension getElementSize(WebDriver driver, String locator){
        return getElement(driver, locator).getSize();
    }
    public List<WebElement> getListElement(WebDriver driver, String locator){
        return driver.findElements(getByLocator(locator));
    }
    public List<WebElement> getListElement(WebDriver driver, String locator, String... restParameter){
        return driver.findElements(getByLocator(castParameter(locator,restParameter)));
    }
    // Truyen tham so vao loai gi se tra ve kieu by tuong ung
    // String prefix: css/id/name/class => By.css/ By.id/ By.name/..
    // Convention: css/ Css/ CSS - id/ ID/ Id/ iD
    // css=buttonlogin => By.cssSelector("button#login");
    // Css=buttonlogin => By.cssSelector("button#login");
    // CSS=buttonlogin => By.cssSelector("button#login");
    public By getByLocator(String prefixLocator){
        By by = null;
        if (prefixLocator.startsWith("css") || prefixLocator.startsWith("CSS") || prefixLocator.startsWith("Css")){
            by = By.cssSelector(prefixLocator.substring(4));
        } else if (prefixLocator.startsWith("id") || prefixLocator.startsWith("Id") || prefixLocator.startsWith("ID"))
        {
            by = By.id(prefixLocator.substring(3));
        } else if (prefixLocator.startsWith("class") || prefixLocator.startsWith("Class") || prefixLocator.startsWith("CLASS"))
        {
            by = By.className(prefixLocator.substring(6));
        } else if (prefixLocator.startsWith("tagname") || prefixLocator.startsWith("Tagname") || prefixLocator.startsWith("TAGNAME"))
        {
            by = By.tagName(prefixLocator.substring(8));
        } else if (prefixLocator.startsWith("Xpath") || prefixLocator.startsWith("XPath") || prefixLocator.startsWith("XPATH"))
        {
            by = By.xpath(prefixLocator.substring(6));
        }
        else if (prefixLocator.startsWith("name") || prefixLocator.startsWith("Name") || prefixLocator.startsWith("NAME"))
        {
            by = By.name(prefixLocator.substring(5));
        }else {
            throw new RuntimeException("Locator type is not support!");
        }
        return by;
    }
    private String castParameter(String locator, String... restParameter){
        return String.format(locator, (Object[]) restParameter);
    }
    public void clickToElement(WebDriver driver, String locator, String... restParameter){
        getElement(driver, castParameter(locator, restParameter)).click();
    }
    public By getByXpath(String locator){
        return By.xpath(locator);
    }
    public void clickToElement(WebDriver driver, String locator){
        getElement(driver, locator).click();
    }
    public void sendKeyToElement(WebDriver driver, String locator, String keysToSend){
        Keys key = null;
        if (GlobalConstants.OS_NAME.startsWith("Windows")){
            key = key.CONTROL;
        } else {
            key = key.COMMAND;
        }
        getElement(driver, locator).sendKeys(Keys.chord(key,"a",Keys.BACK_SPACE));
        sleepInSecond(1);
        getElement(driver, locator).sendKeys(keysToSend);
    }
    public void sendKeyToElement(WebDriver driver, String locator, String keysToSend, String... restParameter){
        getElement(driver, castParameter(locator, restParameter)).clear();
        getElement(driver, castParameter(locator, restParameter)).sendKeys(keysToSend);
    }
    public void selectItemInDropdown(WebDriver driver, String locator, String textItem){
        new Select(getElement(driver, locator)).selectByVisibleText(textItem);
    }
    public void selectItemInDropdown(WebDriver driver, String locator, String textItem, String... restParameter){
        new Select(getElement(driver, castParameter(locator, restParameter))).selectByVisibleText(textItem);
    }
    public String getselectItemInDropdown(WebDriver driver, String locator){
        return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
    }
    public boolean isDropdownMultiple(WebDriver driver, String locator){
        return new Select(getElement(driver, locator)).isMultiple();
    }
    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        sleepInSecond(1);

        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));
        sleepInSecond(1);
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
    public String getElementAttribute(WebDriver driver, String locator, String attributeName, String... restParameter)
    {
        return getElement(driver,castParameter(locator, restParameter)).getAttribute(attributeName);
    }
    public String getElementText(WebDriver driver, String locator)
    {
        return getElement(driver,locator).getText();
    }
    public String getElementText(WebDriver driver, String locator, String... restParameter)
    {
        return getElement(driver,castParameter(locator, restParameter)).getText();
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
    public void checkToCheckboxRadio(WebDriver driver, String locator, String... restParameter){
        if (!getElement(driver, castParameter(locator, restParameter)).isSelected())
        {
            getElement(driver, castParameter(locator, restParameter)).click();
        }
    }
    public void unCheckToCheckboxRadio(WebDriver driver, String locator){
        if (getElement(driver, locator).isSelected())
        {
            getElement(driver, locator).click();
        }
    }
    public void unCheckToCheckboxRadio(WebDriver driver, String locator, String... restParameter){
        if (getElement(driver, castParameter(locator, restParameter)).isSelected())
        {
            getElement(driver, castParameter(locator, restParameter)).click();
        }
    }
    public void overideGlobalTimeout(WebDriver driver, long timeInSecond)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSecond));
    }
    public boolean isElementDisplayed(WebDriver driver, String locator){
            return getElement(driver,locator).isDisplayed();
    }
    public boolean isElementUndisplayed(WebDriver driver, String locator){
        overideGlobalTimeout(driver,GlobalConstants.SHORT_TIME);
        List<WebElement> elements = getListElement(driver,locator);
        overideGlobalTimeout(driver,GlobalConstants.LONG_TIME);
        // Case 1 - Verify confirm email textbox is displaued (visible)
        if (elements.size() == 0){
            return true;
        } else if (elements.size()> 0 && !elements.get(0).isDisplayed()){
            return true;
        }  else {
            return false;
        }
    }
    public boolean isElementDisplayed(WebDriver driver, String locator, String... restParameter){
        return getElement(driver,castParameter(locator, restParameter)).isDisplayed();
    }
    public boolean isElementEnabled(WebDriver driver, String locator){
        return getElement(driver,locator).isEnabled();
    }
    public boolean isElementSelected(WebDriver driver, String locator){
        return getElement(driver,locator).isSelected();
    }
    public boolean isElementSelected(WebDriver driver, String locator, String... restParameter){
        return getElement(driver,castParameter(locator, restParameter)).isSelected();
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
    public void pressKeyToElement(WebDriver driver, String locator, Keys keys, String... restParameter){
        new Actions(driver).sendKeys(getElement(driver, castParameter(locator, restParameter)),keys).perform();
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
    public void clickToElementByJS(WebDriver driver, String locator, String... restParameter) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, castParameter(locator, restParameter)));
        sleepInSecond(2);
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
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIME)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }
    public void  waitForElementVisible(WebDriver driver, String locator, String... restParameter){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIME)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castParameter(locator, restParameter))));
    }
    public void  waitForElementPresence(WebDriver driver, String locator){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIME)).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }
    public void  waitForElementInvisible(WebDriver driver, String locator){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIME)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }
    public boolean waitForListElementInvisible(WebDriver driver, String locator){
        return new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIME))
                .until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver,locator)));
    }
    public void  waitForElementSelected(WebDriver driver, String locator){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIME)).until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }
    public void  waitForElementSelected(WebDriver driver, String locator, String... restParameter){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIME)).until(ExpectedConditions.elementToBeSelected(getByLocator(castParameter(locator, restParameter))));
    }
    public void  waitForElementClickable(WebDriver driver, String locator){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIME)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }
    public void  waitForElementClickable(WebDriver driver, String locator, String... restParameter){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIME)).until(ExpectedConditions.elementToBeClickable(getByLocator(castParameter(locator, restParameter))));
    }
    public void  waitForElementAttribute(WebDriver driver, String locator, String attributeName,String attributeValue){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIME)).until(ExpectedConditions.attributeToBe(getByLocator(locator), attributeName, attributeValue));
    }
    public void  waitForElementAttribute(WebDriver driver, String locator, String attributeName,String attributeValue, String... restParameter){
        new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIME)).until(ExpectedConditions.attributeToBe(getByLocator(castParameter(locator, restParameter)), attributeName, attributeValue));
    }
    public UserAddressPO openAddressPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.ADDRESS_LINK);
        clickToElement(driver, BasePageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }

    public UserRewardPointPO openRewardPointPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.REWARD_POINT_LINK);
        clickToElement(driver, BasePageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewardPointPage(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, BasePageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getUserCustomerInfoPage(driver);
    }
    public UserOrderPO openOrderPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.ORDER_LINK);
        clickToElement(driver, BasePageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }
    public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";

        for (String file : fileNames) {
            fullFileName +=  filePath + file + "\n";
        }

        fullFileName = fullFileName.trim();

        getElement(driver, HomePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
    }
    public void sleepInSecond(long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void enterToTextboxById(WebDriver driver, String textboxId, String value) {
        waitForElementVisible(driver, BasePageUI.TEXT_BY_ID, textboxId);
        sendKeyToElement(driver, BasePageUI.TEXT_BY_ID, value, textboxId);
    }

    public void clickToButtonByText(WebDriver driver, String buttonText) {
        waitForElementClickable(driver, BasePageUI.BUTTON_BY_TEXT, buttonText);
        clickToElement(driver,BasePageUI.BUTTON_BY_TEXT, buttonText);
    }

    public void clickToRadioByID(WebDriver driver, String radioId) {
        waitForElementClickable(driver,BasePageUI.RADIO_BY_ID, radioId);
        checkToCheckboxRadio(driver,BasePageUI.RADIO_BY_ID, radioId);
    }

    public void clickToCheckboxById(WebDriver driver, String checkboxId) {
        waitForElementClickable(driver, BasePageUI.CHECKBOX_BY_ID, checkboxId);
        checkToCheckboxRadio(driver, BasePageUI.CHECKBOX_BY_ID, checkboxId);
    }

    public String getTextboxValueById(WebDriver driver, String textboxId) {
        waitForElementVisible(driver, BasePageUI.TEXT_BY_ID, textboxId);
        return getElementAttribute(driver, BasePageUI.TEXT_BY_ID,"value",textboxId);
    }

    public boolean isRadioByIdSelected(WebDriver driver, String radioId) {
        waitForElementSelected(driver,BasePageUI.RADIO_BY_ID,radioId);
        return isElementSelected(driver, BasePageUI.RADIO_BY_ID, radioId);
    }
    public boolean isCheckboxByIdSelected(WebDriver driver, String checkboxId) {
        waitForElementSelected(driver,BasePageUI.CHECKBOX_BY_ID, checkboxId);
        return isElementSelected(driver, BasePageUI.CHECKBOX_BY_ID, checkboxId);
    }
    public Set<Cookie> getAllCookies(WebDriver driver)
    {
        return driver.manage().getCookies();
    }
    public void setCookies(WebDriver driver, Set<Cookie> cookies)
    {
        for (Cookie cookie:cookies){
            driver.manage().addCookie(cookie);
        }
    }
    public boolean isSuccessMessageIsDisplayed(WebDriver driver) {
        waitForElementVisible(driver, pageUIs.orangeHRM.BasePageUI.SUCCESS_MESSAGE);
        return isElementDisplayed(driver, pageUIs.orangeHRM.BasePageUI.SUCCESS_MESSAGE);
    }
    public boolean waitAllLoadingIconInvisible(WebDriver driver) {
        return waitForListElementInvisible(driver, BasePageUI.LOADING_ICON);
    }
}

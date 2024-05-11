package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    public void clickToElement(WebElement element){
        element.click();
    }
    public void sendKeyToElement(WebElement element, String keyToSend){
        element.sendKeys(keyToSend);
    }
    public void selectItemInDropdown(WebElement element, String textItem){
        new Select(element).selectByVisibleText(textItem);
    }
    public String getElementAttribute(WebElement element, String attributeName){
        return element.getAttribute(attributeName);
    }
    public String getElementText(WebElement element){
        return element.getText();
    }
    public void  waitForElementVisible(WebDriver driver, WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(element));
    }
    public void  waitForElementClickable(WebDriver driver, WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(element));
    }
    public boolean isElementDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public boolean isElementSelected(WebElement element){
        return element.isSelected();
    }
    public void checkToCheckboxRadio(WebElement element){
        if (!element.isSelected())
        {
            element.click();
        }
    }
    public void  waitForElementSelected(WebDriver driver, WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeSelected(element));
    }
    public String getselectItemInDropdown(WebElement element){
        return new Select(element).getFirstSelectedOption().getText();
    }
}

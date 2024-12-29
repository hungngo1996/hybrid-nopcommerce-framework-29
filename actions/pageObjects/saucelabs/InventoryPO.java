package pageObjects.saucelabs;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.facebook.LoginPageUI;
import pageUIs.sauceLabs.InventoryPageUI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryPO extends BasePage {
    private WebDriver driver;
    public InventoryPO(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSortDropdown(String sortItem) {
        waitForElementClickable(driver, InventoryPageUI.SORT_DROPDOWN);
        selectItemInDropdown(driver, InventoryPageUI.SORT_DROPDOWN, sortItem);
        sleepInSecond(2);
    }
    //Java 7
    public boolean isNameSortAscending() {
        List<WebElement> productNameElement = getListElement(driver, InventoryPageUI.PRODUCT_NAME);

        List<String> productNameText = new ArrayList<String>();

        for (WebElement productName: productNameElement){
            String text = productName.getText();
            productNameText.add(text);
        }
        System.out.println(productNameText);
        List<String> productNameTextClone = new ArrayList<>(productNameText);

        Collections.sort(productNameTextClone);
        System.out.println(productNameTextClone);
        return productNameTextClone.equals(productNameText);
    }

    // Java 8 trở lên
//    public boolean isNameSortAscending() {
//        List<WebElement> productNameElement = getListElement(driver, InventoryPageUI.PRODUCT_NAME);
//        List<String> productNameText = productNameElement.stream().
//                map(n -> n.getText()).collect(Collectors.toList());
//
//        List<String> productNameTextClone = new ArrayList<>(productNameText);
//        Collections.sort(productNameTextClone);
//        return productNameTextClone.equals(productNameText);
//    }
//
//    // Java 16
//    public boolean isDataSortedAsc(WebDriver driver, String locator) {
//        var elementLists = driver.findElements(By.xpath(locator));
//        var names = elementLists.stream()
//                .map(WebElement::getText)
//                .toList(); // Sử dụng phương thức toList() từ Java 16
//
//        var sortedNames = names.stream().sorted()
//                .toList(); // Trực tiếp sắp xếp bằng Stream
//
//        return names.equals(sortedNames);
//    }

    public boolean isNameSortDescending() {
        List<WebElement> productNameElement = getListElement(driver, InventoryPageUI.PRODUCT_NAME);

        List<String> productNameText = new ArrayList<String>();

        for (WebElement productName: productNameElement){
            String text = productName.getText();
            productNameText.add(text);
        }
        System.out.println(productNameText);
        List<String> productNameTextClone = new ArrayList<>(productNameText);

        Collections.sort(productNameTextClone);
        Collections.reverse(productNameTextClone);
        System.out.println(productNameTextClone);
        return productNameTextClone.equals(productNameText);
    }

    public boolean isPriceSortAscending() {
        List<WebElement> productPriceElement = getListElement(driver, InventoryPageUI.PRODUCT_PRICE);

        List<Float> productPriceText = new ArrayList<Float>();

        for (WebElement productName: productPriceElement){
            String text = productName.getText().replace("$","");
            productPriceText.add(Float.valueOf(text));
        }
        System.out.println(productPriceText);
        List<Float> productPriceTextClone = new ArrayList<Float>(productPriceText);

        Collections.sort(productPriceTextClone);
        System.out.println(productPriceTextClone);
        return productPriceTextClone.equals(productPriceText);
    }

    public boolean isPriceSortDescending() {
        List<WebElement> productPriceElement = getListElement(driver, InventoryPageUI.PRODUCT_PRICE);

        List<Float> productPriceText = new ArrayList<Float>();

        for (WebElement productName: productPriceElement){
            String text = productName.getText().replace("$","");
            productPriceText.add(Float.valueOf(text));
        }
        System.out.println(productPriceText);
        List<Float> productPriceTextClone = new ArrayList<Float>(productPriceText);

        Collections.sort(productPriceTextClone);
        Collections.reverse(productPriceTextClone);
        System.out.println(productPriceTextClone);
        return productPriceTextClone.equals(productPriceText);
    }
}

package pageUIs.nopCommerce;

public class BasePageUI {
    //Nopcommerce
    public static final String ORDER_LINK = "Xpath=//div[contains(@class, 'block-account-navigation')]//a[text()='Orders']";
    public static final String ADDRESS_LINK = "Xpath=//div[contains(@class, 'block-account-navigation')]//a[text()='Addresses']";
    public static final String REWARD_POINT_LINK = "Xpath=//div[contains(@class, 'block-account-navigation')]//a[text()='Reward points']";
    public static final String CUSTOMER_INFO_LINK = "Xpath=//div[contains(@class, 'block-account-navigation')]//a[text()='Customer info']";
    public static final String TEXT_BY_ID = "Xpath=//input[@id='%s']";
    public static final String CHECKBOX_BY_ID = "Xpath=//input[@id='%s']";
    public static final String RADIO_BY_ID = "Xpath=//input[@id='%s']";
    public static final String BUTTON_BY_TEXT = "Xpath=//button[text()='%s']";

    //OrangeHRM
    public static final String LOADING_ICON = "Css=div.oxd-loading-spinner";
}

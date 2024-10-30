package pageUIs.orangeHRM.pim;

public class AddNewPageUI {
    public static final String FIRSTNAME_TEXTBOX = "Css=input[name=firstName]";
    public static final String LASTNAME_TEXTBOX = "Css=input[name=lastName]";
    public static final String EMPLOYEE_ID_TEXTBOX
            = "Xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER =
            "Xpath=//h6[text()='Add Employee']/following-sibling::form//button[contains(string(),'Save')]";
}

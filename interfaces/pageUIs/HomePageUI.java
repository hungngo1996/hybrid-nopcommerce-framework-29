package pageUIs;

public class HomePageUI {
    public static final String REGISTER_LINK = "//a[@class='ico-register']";
    // Public: gọi hàm/biến ra sử dụng bình thường
    // Private/ default: khác package ko dùng được
    // Protected: các class bên PO ko kế thừa PUI nên không dùng
    // Static: cho phép gọi trực tiếp từ class
    // Final: ngăn việc update lại giá trị trong quá trình chạy
    // String: vì cái By loccator của selenium đều nhận vào String
    // REGISTER_LINK: static final để quy ước 1 biến là HẰNG SỐ trong JAVA
    // Convention cho hằng số: Phải viết hoa - nhiều hơn 1 từ phải dùng dấu gạch dưới để tách ra
    public static final String MY_ACCOUNT_LINK = "//a[@class='ico-account' and text()='My account']";
}

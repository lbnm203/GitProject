package product_selling.view;

import product_selling.common.validate.Validate;
import product_selling.entity.Product;

import java.util.List;

public class CartMenu {
    public static void cartMenu() {
        int choice;
        while (true) {
            showCartMenu();
            choice = Validate.inputInteger("lựa chọn của bạn");
            switch (choice) {
                case 1 -> {
                    return;
                }
                case 2 -> {
                    return;
                }
                case 3 -> {
                    return;
                }

                case 0 -> MainMenu.mainMenu();
                default -> System.out.println("Yêu cầu không hợp lệ, hãy nhập lại!");
            }
        }

    }

    public static void showCartMenu() {
        System.out.println("""
        ==============MENU GIỎ HÀNG===============
          1. Hiển thị sản phẩm trong giỏ hàng            
          2. Xóa sản phẩm trong giỏ hàng                 
          3. Thanh toán              
          0. Thoát                             
        ==========================================
        """);
    }
}

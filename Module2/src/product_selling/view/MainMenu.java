package product_selling.view;

import product_selling.common.validate.Validate;
import product_selling.controller.CustomerController;
import product_selling.controller.ProductController;
import product_selling.entity.Bag;
import product_selling.entity.Product;
import product_selling.entity.Tarp;


import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private static final ProductController controller = new ProductController();
    private static final CustomerController customerController = new CustomerController();

    public static void mainMenu() {
        int choice;
        while (true) {
            showMenu();
            choice = Validate.inputInteger("lựa chọn của bạn");
            switch (choice) {
                case 1 -> {
                    ProductDetailMenu.productMenu();
                }

                case 2 -> CartMenu.cartMenu();

                case 3 -> {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("========== ĐĂNG NHẬP ADMIN ==========");
                    System.out.print("Nhập tài khoản: ");
                    String username = sc.nextLine().trim().toLowerCase();

                    System.out.print("Nhập mật khẩu: ");
                    String password = sc.nextLine().trim().toLowerCase();

                    if (controller.checkLoginAdmin(username, password)) {
                        System.out.println("Đăng nhập thành công");
                        AdminMenu.adminMenu();
                    } else {
                        System.out.println("Sai tên đăng nhập hoặc mật khẩu, vui lòng đăng nhập lại!");
                    }
                }

                case 0 -> {
                    System.out.println("Tạm biệt!");
                    System.exit(0);;
                }

                default -> System.out.println("Yêu cầu không hợp lệ, hãy nhập lại!");
            }
        }

    }

    public static void showMenu() {
        System.out.println("""
        ================MENU CHÍNH=================
          1. Hiển thị danh sách mặt hàng                          
          2. Giỏ hàng                                            
          3. [ADMIN] Quản lý sản phẩm          
          0. Thoát                             
        ==========================================
        """);
    }
}

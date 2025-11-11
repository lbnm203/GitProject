package product_selling.view;

import product_selling.common.validate.Validate;
import product_selling.controller.CartController;
import product_selling.controller.CustomerController;
import product_selling.controller.ProductController;
import product_selling.entity.Bag;
import product_selling.entity.Product;
import product_selling.entity.ProductType;
import product_selling.entity.Tarp;

import java.util.List;
import java.util.Scanner;

public class SubSearchProductMenu {
    private static final ProductController productController = new ProductController();
    private static final CartController controller = new CartController();
    private static final CustomerController customerController = new CustomerController();
    private static final Scanner sc = new Scanner(System.in);

    public static void searchMenu() {
        int choice;
        while (true) {
            showSearchProductMenu();
            choice = Validate.inputInteger("lựa chọn của bạn");
            switch (choice) {
                case 1 -> {
                    int id = Validate.inputInteger("Nhập ID sản phẩm muốn thêm: ");
                    Product product = productController.findById(id);
                    if (product == null) {
                        System.out.println("Không tìm thấy sản phẩm có ID: " + id);
                        return;
                    }
                    double quantity = Validate.inputDouble("Nhập số lượng muốn thêm: ");
                    customerController.addToCart(id, quantity);
                }
                case 0 -> {
                    ProductDetailMenu.showProductMenu();
                    return;
                }
                default -> System.out.println("Yêu cầu không hợp lệ, hãy nhập lại!");
            }
        }
    }

    public static void showSearchProductMenu() {
        System.out.println("""
                ============MENU TÌM KIẾM============g
                  1. Thêm mặt hàng vào giỏ hàng
                  0. Trở về trang mặt hàng
                ==========================================
                """);
    }
}

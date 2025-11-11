package product_selling.view;

import product_selling.common.validate.Validate;
import product_selling.controller.CartController;
import product_selling.controller.ProductController;
import product_selling.entity.CartItem;

import java.util.List;
import java.util.Scanner;

public class CartMenu {
    private static final CartController controller = new CartController();

    public static void cartMenu() {
        int choice;
        while (true) {
            showCartMenu();
            choice = Validate.inputInteger("lựa chọn của bạn");
            switch (choice) {
                case 1 -> {
                    List<CartItem> listItem =  controller.getProductInCart();
                    displayAll(listItem);
                }
                case 2 -> {
                    List<CartItem> listItem =  controller.getProductInCart();
                    displayAll(listItem);
                    int deleteID = Validate.inputInteger("ID muốn xóa: ");
                    if (confirmDelete(deleteID)) {
                        controller.removeFromCart(deleteID);
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Hủy thao tác xóa!");
                    }
                }
                case 3 -> {
                    List<CartItem> listItem =  controller.getProductInCart();
                    displayAll(listItem);
                    if (confirmCheckout(listItem)) {
                        controller.payCart();
                    } else {
                        System.out.println("Hủy Thao Tác Thanh Toán");
                    }
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

    public static void displayAll(List<CartItem> items) {
        if (items.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        double grandTotal = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("   GIỎ HÀNG CỦA BẠN                \n");
        sb.append(String.format("%-5s %-20s %-20s %-15s %-15s %-20s\n",
                "ID", "Name", "Collection", "Price", "NumOfProducts", "Total"));
        sb.append("-".repeat(70) + "\n");

        for (CartItem item : items) {
            grandTotal += item.getTotalPrice();
            sb.append(String.format("%-5s %-20s %-20s %-15.2f %-15.2f %-20.2f\n",
                    item.getProduct().getId(),
                    item.getProduct().getName(),
                    item.getProduct().getCollection(),
                    item.getProduct().getPrice(),
                    item.getQuantity(),
                    item.getTotalPrice()));
            }

        sb.append("-".repeat(70) + "\n");
        sb.append(String.format(" TỔNG TIỀN: %-15.0f VNĐ\n", grandTotal));
        System.out.println(sb);
    }

    public static boolean confirmDelete(int id) {
        CartItem items = controller.findById(id);
        if (items == null) {
            System.out.println("Không tìm thấy sản phẩm có ID: " + id);
            return false;
        }

        System.out.println("Bạn có chắc muốn xóa sản phẩm có ID là " + items.getProduct().getId() + " không? (y/n)");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine().trim().toLowerCase();

        return choice.equals("y") || choice.equals("yes");
    }

    public static boolean confirmCheckout(List<CartItem> items) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bạn xác nhận thanh toán? (y/n)");
        String confirm = sc.nextLine().trim().toLowerCase();
        return confirm.equals("y") || confirm.equals("yes");
    }
}

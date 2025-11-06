package product_selling.view;

import product_selling.common.validate.Validate;
import product_selling.controller.CustomerController;
import product_selling.controller.ProductController;
import product_selling.entity.Bag;
import product_selling.entity.Product;
import product_selling.entity.Tarp;


import java.util.List;

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
                    List<Product> listProduct = controller.getAllProducts();
                    displayAll(listProduct);
                }

                case 2 -> {
                    int id = Validate.inputInteger("Nhập ID sản phẩm muốn thêm: ");
                    Product product = controller.findById(id);
                    if (product == null) {
                        System.out.println("Không tìm thấy sản phẩm có ID: " + id);
                        return;
                    }
                    double quantity = Validate.inputDouble("Nhập số lượng muốn thêm: ");
                    customerController.addToCart(id, quantity);
                    System.out.println("Đã thêm sản phẩm vào giỏ hàng!");
                }

                case 3 -> CartMenu.cartMenu();

                case 4 -> AdminMenu.adminMenu();

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
          2. Thêm mặt hàng vào giỏ hàng                 
          3. Xem giỏ hàng                                            
          4. [ADMIN] Quản lý sản phẩm          
          0. Thoát                             
        ==========================================
        """);
    }

    public static void displayAll(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %-5s %-20s %-20s %-15s %-15s\n",
                "Type", "ID", "Name", "Collection", "Price", "NumOfProducts"));
        sb.append("--------------------------------------------------------------------------------------------\n");

        for (Product product : products) {
            String numOfProduct = "";
            if (product instanceof Bag) {
                numOfProduct = String.valueOf(((Bag) product).getNumberOfItems());
            } else if (product instanceof Tarp) {
                numOfProduct = String.valueOf(((Tarp) product).getNumberOfMeters());
            }

            sb.append(String.format("%-10s %-5s %-20s %-20s %-15.2f %-15s\n",
                    product.getType(),
                    product.getId(),
                    product.getName(),
                    product.getCollection(),
                    product.getPrice(),
                    numOfProduct));
        }

        System.out.println(sb);
    }
}

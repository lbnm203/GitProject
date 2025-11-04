package product_selling.view;

import product_selling.common.validate.Validate;
import product_selling.controller.ProductController;
import product_selling.entity.Bag;
import product_selling.entity.Product;
import product_selling.entity.Tarp;


import java.util.List;

public class MainMenu {
    private static final ProductController controller = new ProductController();

    public static void mainMenu() {
        int choice;
        showMenu();
        while (true) {
            choice = Validate.inputInteger("lựa chọn của bạn");
            switch (choice) {
                case 1 -> {
                    List<Product> listProduct = controller.getAllProducts();
                    displayAll(listProduct);
                }
                case 2 -> {
                    return;
                }
                case 3 -> {
                    return;
                }
                case 4 -> {
                    return;
                }
                case 5 -> AdminMenu.adminMenu();

                case 0 -> {
                    System.out.println("Tạm biệt!");
                    System.exit(0);;
                }
            }
        }

    }

    public static void showMenu() {
        System.out.println("""
        ===================MENU===================
          1. Hiển thị danh sách mặt hàng            
          2. Thêm mặt hàng vào giỏ hàng                 
          3. Xem giỏ hàng                      
          4. Thanh toán                        
          5. [ADMIN] Quản lý sản phẩm          
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

package product_selling.view;
import product_selling.common.exception.IdDuplicatedException;
import product_selling.common.validate.Validate;
import product_selling.controller.ProductController;
import product_selling.entity.Bag;
import product_selling.entity.Product;
import product_selling.entity.Tarp;

import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    private static final ProductController controller = new ProductController();

    public static void adminMenu() {
        showMenuAdmin();
        int choiceAdmin;
        while (true) {
            choiceAdmin = Validate.inputInteger("lựa chọn của bạn");
            switch (choiceAdmin) {
                case 1 -> {
                    List<Product> listProduct = controller.getAllProducts();
                    displayAll(listProduct);
                }
                case 2 -> {
                    Product product = inputProduct();
                    controller.addProduct(product);
                    System.out.println("Thêm thành công");
                }
                case 3 -> {
                    return;
                }
                case 4 -> {
                    return;
                }
                case 0 -> MainMenu.mainMenu();
                default -> System.out.println("Yêu cầu không hợp lệ, hãy nhập lại!");
            }
        }
    }

    public static void showMenuAdmin() {
        System.out.println("""
                ================MENU ADMIN================
                  1. Hiển thị danh sách mặt hàng
                  2. Thêm mặt hàng mới
                  3. Xóa mặt hàng
                  4. Cập nhật mặt hàng
                  0. Trở về trang chính
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

    public static Product inputProduct() {
        Scanner sc = new Scanner(System.in);
        int id;
        while (true) {
            try {
                id = Validate.inputInteger("Id");
                controller.checkDuplicateId(id);
                break;
            } catch (IdDuplicatedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Nhập tên mặt hàng: ");
        String name = sc.nextLine();

        System.out.print("Nhập loại mặt hàng: ");
        String collection = sc.nextLine();

        double price = Validate.inputDouble("Nhập giá mặt hàng: ");

        System.out.print("Nhập loại sản phẩm (Bao/Bat): ");
        String type = sc.nextLine().trim();

        if (type.equalsIgnoreCase("Bao")) {
            int numberOfItems = Validate.inputInteger("Số lượng sản phẩm trong bao");
            return new Bag(id, name, collection, price, numberOfItems);
        } else if (type.equalsIgnoreCase("Bat")) {
            double numberOfMeters = Validate.inputDouble("Số mét trong bạt");
            return new Tarp(id, name, collection, price, numberOfMeters);
        } else {
            System.out.println("Loại không hợp lệ. Mặc định tạo sản phẩm Bao.");
            int numberOfItems = Validate.inputInteger("Số lượng sản phẩm trong bao");
            return new Bag(id, name, collection, price, numberOfItems);
        }
    }
}

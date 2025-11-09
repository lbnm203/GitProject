package product_selling.view;

import product_selling.common.validate.Validate;
import product_selling.controller.CartController;
import product_selling.controller.CustomerController;
import product_selling.controller.ProductController;
import product_selling.entity.*;

import java.util.List;
import java.util.Scanner;

public class ProductDetailMenu {
    private static final ProductController productController = new ProductController();
    private static final CartController controller = new CartController();
    private static final CustomerController customerController = new CustomerController();
    private static final Scanner sc = new Scanner(System.in);

    public static void productMenu() {
        int choice;
        while (true) {
            showProductMenu();
            choice = Validate.inputInteger("lựa chọn của bạn");
            switch (choice) {
                case 1 -> {
                    List<Product> listProduct = productController.getAllProducts();
                    displayDetail(listProduct);
                }
                case 2 -> {
                    List<Product> listProduct = productController.getAllProducts();
                    displayAll(listProduct);
                    int id = Validate.inputInteger("Nhập ID sản phẩm muốn thêm: ");
                    Product product = productController.findById(id);
                    if (product == null) {
                        System.out.println("Không tìm thấy sản phẩm có ID: " + id);
                        return;
                    }
                    double quantity = Validate.inputDouble("Nhập số lượng muốn thêm: ");
                    customerController.addToCart(id, quantity);
                }
                case 3 -> {
                    System.out.println("Nhập tên sản phẩm muốn tìm kiếm: ");
                    String nameSearch = sc.nextLine().trim();
                    List<Product> productName = customerController.searchProductByName(nameSearch);
                    if (productName.isEmpty()) {
                        System.out.println("Không tìm thấy sản phẩm");
                    } else {
                        displayDetail(productName);
                    }
                }
                case 4 -> {
                    double priceSearch = Validate.inputDouble("Nhập giá tiền sản phẩm muốn tìm kiếm: ");
                    List<Product> productPrice = customerController.searchProductByPrice(priceSearch);
                    if (productPrice.isEmpty()) {
                        System.out.println("Không tìm thấy sản phẩm có giá tiền " + priceSearch);
                    } else {
                        displayDetail(productPrice);
                    }
                }
                case 5 -> {
                    System.out.println("Nhập loại sản phẩm muốn tìm kiếm: ");
                    String typeSearch = sc.nextLine().trim();
                    List<Product> productType = customerController.searchProductByType(ProductType.valueOf(typeSearch));
                    if (productType.isEmpty()) {
                        System.out.println("Không tìm thấy sản phẩm có loại " + typeSearch);
                    } else {
                        displayDetail(productType);
                    }
                }
                case 0 -> MainMenu.mainMenu();
                default -> System.out.println("Yêu cầu không hợp lệ, hãy nhập lại!");
            }
        }
    }

    public static void showProductMenu() {
        System.out.println("""
                ============MENU CHI TIẾT SẢN PHẨM============
                  1. Hiển thị chi tiết mặt hàng
                  2. Thêm mặt hàng vào giỏ hàng
                  3. Tìm kiếm mặt hàng theo tên
                  4. Tìm kiếm mặt hàng theo giá tiền
                  5. Tìm kiếm mặt hàng theo loại hàng (type)
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
        sb.append("-".repeat(90) + "\n");

        for (Product product : products) {
            double numOfProduct = 0;
            if (product instanceof Bag bag) {
                numOfProduct = bag.getNumberOfItems();
            } else if (product instanceof Tarp tarp) {
                numOfProduct = tarp.getNumberOfMeters();
            }

            sb.append(String.format("%-10s %-5s %-20s %-20s %-15.2f %-15.2f\n",
                    product.getType(),
                    product.getId(),
                    product.getName(),
                    product.getCollection(),
                    product.getPrice(),
                    numOfProduct));
        }

        System.out.println(sb);
    }

    public static void displayDetail(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %-5s %-20s %-20s %-15s %-15s %-20s\n",
                "Type", "ID", "Name", "Collection", "Price", "NumOfProducts", "Description"));
        sb.append("-".repeat(90) + "\n");


        for (Product product : products) {
            double numOfProduct = 0;
            if (product instanceof Bag bag) {
                numOfProduct = bag.getNumberOfItems();
            } else if (product instanceof Tarp tarp) {
                numOfProduct = tarp.getNumberOfMeters();
            }

            sb.append(String.format("%-10s %-5s %-20s %-20s %-15.2f %-15.2f %-20s\n",
                    product.getType(),
                    product.getId(),
                    product.getName(),
                    product.getCollection(),
                    product.getPrice(),
                    numOfProduct,
                    product.getDescription()));
        }

        System.out.println(sb);
    }
}

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

public class SubAddProductMenu {
    private static final ProductController productController = new ProductController();
    private static final CartController controller = new CartController();
    private static final CustomerController customerController = new CustomerController();
    private static final Scanner sc = new Scanner(System.in);

    public static void addProductMenu() {
        int choice;
        while (true) {
            showSubProductMenu();
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
                case 0 -> {
                    ProductDetailMenu.showProductMenu();
                    return;
                }
                default -> System.out.println("Yêu cầu không hợp lệ, hãy nhập lại!");
            }
        }
    }

    public static void showSubProductMenu() {
        System.out.println("""
                ============MENU XÁC NHẬN============
                  1. Hiển thị chi tiết mặt hàng
                  2. Thêm mặt hàng vào giỏ hàng
                  0. Trở về trang mặt hàng
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

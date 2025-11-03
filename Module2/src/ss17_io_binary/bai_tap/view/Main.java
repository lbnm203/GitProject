package ss17_io_binary.bai_tap.view;

import ss17_io_binary.bai_tap.controller.ProductController;
import ss17_io_binary.bai_tap.entity.Product;
import ss17_io_binary.bai_tap.service.ProductService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final ProductController controller = new ProductController();
    private static final ProductService service = new ProductService();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Tìm kiếm thông tin sản phẩm");
            System.out.println("0. Thoát");

            System.out.println("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    while (service.isDuplicateId(id)) {
                        System.out.println("ID đã trùng! Hãy nhập lại!");
                        id = Integer.parseInt(sc.nextLine());
                    }

                    System.out.print("Nhập tên sản phẩm: ");
                    String name = sc.nextLine();

                    System.out.print("Nhập giá sản phẩm: ");
                    double price = Double.parseDouble(sc.nextLine());

                    System.out.print("Nhập tên hãng: ");
                    String brand = sc.nextLine();

                    System.out.print("Nhập mô tả: ");
                    String description = sc.nextLine();

                    Product product = new Product(id, name, price, brand, description);
                    controller.addProduct(product);
                    System.out.println("Thêm thành công");
                    break;
                case 2:
                    List<Product> listProduct = controller.getAllProducts();
                    displayAll(listProduct);
                    break;
                case 3:
                    System.out.println("Nhập tên sản phẩm muốn tìm kiếm: ");
                    String nameSearch = sc.nextLine();
                    List<Product> productName = controller.searchProduct(nameSearch);
                    if (productName.isEmpty()) {
                        System.out.println("Không tìm thấy sản phẩm");
                    } else {
                        displayAll(productName);
                    }
                    break;
                case 0:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        } while (choice != 0);
    }

    public static void displayAll(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-5s %-20s %-15s %-15s %-20s \n", "ID", "Name", "Price", "Brand", "Description"));
        sb.append("-----------------------------------------------------------------------------\n");
        for (Product product : products) {
            sb.append(String.format("%-5s %-20s %-15s %-15s %-20s\n",
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getBrand(),
                    product.getDescription()));
        }
        System.out.println(sb);
    }
}

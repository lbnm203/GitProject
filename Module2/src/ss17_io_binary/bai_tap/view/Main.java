package ss17_io_binary.bai_tap.view;

import ss17_io_binary.bai_tap.controller.ProductController;
import ss17_io_binary.bai_tap.entity.Product;

import java.util.Scanner;

public class Main {
    private static final ProductController controller = new ProductController();
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
                    while (controller.isDuplicateId(id)) {
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
                    controller.displayAll();
                    break;
                case 3:
                    System.out.println("Nhập tên sản phẩm muốn tìm kiếm: ");
                    String nameSearch = sc.nextLine();
                    controller.searchProduct(nameSearch);
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

}

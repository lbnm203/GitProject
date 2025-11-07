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
        int choiceAdmin;
        while (true) {
            showMenuAdmin();
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
                    int deleteID = Validate.inputInteger("ID muốn xóa: ");
                    if (confirmDelete(deleteID)) {
                        controller.deleteProduct(deleteID);
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Hủy thao tác xóa!");
                    }
                }
                case 4 -> {
                    int editID = Validate.inputInteger("ID cần sửa: ");
                    Product product = controller.findById(editID);

                    if (product == null) {
                        System.out.println("Không tìm thấy sản phẩm có ID: " + editID);
                        break;
                    }

                    System.out.println("Thông tin sản phẩm cần chỉnh sửa: ");
                    displayOne(product);

                    Scanner sc = new Scanner(System.in);
                    System.out.println("Nhập tên mới: ");
                    String newName = sc.nextLine().trim();

                    System.out.println("Nhập loại mặt hàng mới: ");
                    String newCollection = sc.nextLine().trim();

                    double newPrice = Validate.inputDouble("Nhập giá mới: ");
                    double newStock = 0;

                    if (product instanceof Bag) {
                        newStock = Validate.inputInteger("Nhập số lượng trong bao: ");
                    } else if (product instanceof Tarp) {
                        newStock = Validate.inputDouble("Nhập tổng số mét bạt: ");
                    }

                    controller.editProduct(editID, newName, newCollection, newPrice, newStock);
                }
                case 0 -> MainMenu.mainMenu();
                default -> System.out.println("Yêu cầu không hợp lệ, hãy nhập lại!");
            }
        }
    }

    public static void showMenuAdmin() {
        System.out.println("""
                ============MENU QUẢN TRỊ VIÊN============
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
            double numberOfMeters = Validate.inputDouble("Số lượng tổng mét bạt");
            return new Tarp(id, name, collection, price, numberOfMeters);
        } else {
            System.out.println("Loại không hợp lệ. Mặc định tạo sản phẩm Bao.");
            int numberOfItems = Validate.inputInteger("Số lượng tổng có trong bao");
            return new Bag(id, name, collection, price, numberOfItems);
        }
    }

    public static boolean confirmDelete(int id) {
        Product product = controller.findById(id);
        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm có ID: " + id);
            return false;
        }

        System.out.println("Bạn muốn xóa sẩn phẩm: ");
        displayOne(product);

        System.out.println("Bạn có chắc muốn xóa sản phẩm trên không? (y/n)");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine().trim().toLowerCase();

        return choice.equals("y") || choice.equals("yes");
    }

    public static void displayOne(Product product) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %-5s %-20s %-20s %-15s %-15s\n",
                "Type", "ID", "Name", "Collection", "Price", "NumOfProducts"));
        sb.append("--------------------------------------------------------------------------------------------\n");


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

        System.out.println(sb);
    }
}

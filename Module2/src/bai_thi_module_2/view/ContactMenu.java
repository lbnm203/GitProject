package bai_thi_module_2.view;

import java.util.Scanner;

public class MainMenu {
    public static void mainMenu() {
        int choice;
        while (true) {
            showMainMenu();
            choice = inputInteger("Chọn chức năng: ");
            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                default:
                    break;
            }
        }
    }

    public static void showMainMenu() {
        System.out.println("""
                ============CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ============
                  1. Xem danh sách
                  2. Thêm mới
                  3. Cập nhật
                  4. Xóa
                  5. Tìm kiếm
                  6. Đọc từ file
                  7. Ghi vào file
                  8. Thoát
                ==========================================
                """);
    }

//    public static void displayAll(List<Product> products) {
//        if (products.isEmpty()) {
//            System.out.println("List is empty!");
//            return;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("%-10s %-5s %-20s %-20s %-15s %-15s %-20s\n",
//                "Type", "ID", "Name", "Collection", "Price", "NumOfProducts", "Description"));
//        sb.append("--------------------------------------------------------------------------------------------\n");
//
//        for (Product product : products) {
//            double numOfProduct = 0;
//            if (product instanceof Bag bag) {
//                numOfProduct = bag.getNumberOfItems();
//            } else if (product instanceof Tarp tarp) {
//                numOfProduct = tarp.getNumberOfMeters();
//            }
//
//            sb.append(String.format("%-10s %-5s %-20s %-20s %-15.2f %-15.2f %-20s\n",
//                    product.getType(),
//                    product.getId(),
//                    product.getName(),
//                    product.getCollection(),
//                    product.getPrice(),
//                    numOfProduct,
//                    product.getDescription()));
//        }
//
//        System.out.println(sb);
//    }

    public static int inputInteger(String mess) {
        Scanner scanner = new Scanner(System.in);
        int temp;
        while (true) {
            try {
                temp = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(mess + " phải là số nguyên. Vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định. Vui lòng nhập lại");
            }
        }
        return temp;
    }

    public static double inputDouble(String mess) {
        Scanner sc = new Scanner(System.in);
        double temp;
        while (true) {
            try {
                temp = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(mess + " phải là kiểu double. Vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định. Vui lòng nhập lại");
            }
        }
        return temp;
    }
}
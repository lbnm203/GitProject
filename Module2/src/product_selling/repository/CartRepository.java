package product_selling.repository;

import product_selling.entity.Bag;
import product_selling.entity.CartItem;
import product_selling.entity.Product;
import product_selling.entity.Tarp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartRepository {
    private static final String path = "src/product_selling/data/products_in_cart.csv";
    private static final String PRODUCT_PATH = "src/product_selling/data/products.csv";

    public List<CartItem> getProductInCart() {
        return readCartFile();
    }

    public void removeFromCart(int id) {
        List<CartItem> items = readCartFile();
        items.removeIf(item -> item.getProduct().getId() == id);
        writeFile(items, false);
    }

    private static List<Product> readFile() {
        List<Product> products = new ArrayList<>();

        try (FileReader fileReader = new FileReader(PRODUCT_PATH);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String[] data;
            int numOfItems;
            double numOfMeter;
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(",");
                if (data[0].trim().equalsIgnoreCase("Bao")) {
                    numOfItems = Integer.parseInt(data[5]);
                    products.add(new Bag(Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4]), numOfItems));
                } else if (data[0].trim().equalsIgnoreCase("Bat")) {
                    numOfMeter = Double.parseDouble(data[5]);
                    products.add(new Tarp(Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4]), numOfMeter));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File không tìm thấy");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return products;
    }


    private static List<CartItem> readCartFile() {
        List<CartItem> items = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String collection = data[2];
                double price = Double.parseDouble(data[3]);
                double quantity = Double.parseDouble(data[4]);

                Product product = new Product(id, name, collection, price);
                items.add(new CartItem(product, quantity));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File không tìm thấy");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return items;
    }

    private static void writeFile(List<CartItem> items, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
            for (CartItem item : items) {
                Product p = item.getProduct();
                String line = String.join(",",
                        String.valueOf(p.getId()),
                        p.getName(),
                        p.getCollection(),
                        String.valueOf(p.getPrice()),
                        String.valueOf(item.getQuantity())
                );
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    private static void writeProductFile(List<Product> products, boolean append) {
        try (FileWriter fileWriter = new FileWriter(PRODUCT_PATH, append);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Product product : products) {
                bufferedWriter.write(product.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }

    public CartItem getCartItemById(int id) {
        List<CartItem> items = readCartFile();
        for (CartItem item : items) {
            if (item.getProduct().getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void payCart() {
        List<CartItem> items = readCartFile();
        if (items.isEmpty()) {
            System.out.println("Giỏ hàng hiện tại không có sản phẩm để thanh toán!");
        }

        double totalPayment = 0;
        double quantity;
        List<Product> products = readFile();

        for (CartItem item : items) {
            Product cartProduct = item.getProduct();
            quantity = item.getQuantity();

            for (Product product : products) {
                if (product.getId() == cartProduct.getId()) {
                    if (product instanceof Bag bag) {
                        int remaining = bag.getNumberOfItems() - (int) quantity;
                        bag.setNumberOfItems(remaining);
                    } else if (product instanceof Tarp tarp) {
                        double remaining = tarp.getNumberOfMeters() - quantity;
                        tarp.setNumberOfMeters(remaining);
                    }
                    break;
                }
            }
            totalPayment += item.getTotalPrice();
        }
        writeProductFile(products, false);
        writeFile(new ArrayList<>(), false);
        System.out.printf("Thanh Toán Thành Công! - Tổng tiền sản phẩm: %.0f VND%n", totalPayment);
        System.out.println("\n");
    }
}

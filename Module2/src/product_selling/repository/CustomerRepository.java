package product_selling.repository;

import product_selling.entity.Bag;
import product_selling.entity.Product;
import product_selling.entity.CartItem;
import product_selling.entity.Tarp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private static final String path = "src/product_selling/data/products_in_cart.csv";
    private static final String PRODUCT_PATH = "src/product_selling/data/products.csv";

    public List<Product> getAllProducts() {
        return readFile();
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
                int quantity = Integer.parseInt(data[4]);

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
        try (FileWriter fileWriter = new FileWriter(path, append);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (CartItem item : items) {
                bufferedWriter.write(item.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }

    public void addProduct(int productId, int quantity) {
        List<Product> allProducts = readFile();
        Product found = null;

        for (Product p : allProducts) {
            if (p.getId() == productId) {
                found = p;
                break;
            }
        }

        if (found == null) {
            System.out.println("Không tìm thấy sản phẩm có ID: " + productId);
            return;
        }

        List<CartItem> cart = readCartFile();

        // Nếu đã có sản phẩm trong giỏ -> tăng số lượng
        boolean existed = false;
        for (CartItem item : cart) {
            if (item.getProduct().getId() == productId) {
                item.setQuantity(item.getQuantity() + quantity);
                existed = true;
                break;
            }
        }

        // Nếu chưa có -> thêm mới
        if (!existed) {
            cart.add(new CartItem(found, quantity));
        }

        writeFile(cart, false);
    }
}

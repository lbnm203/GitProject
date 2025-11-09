package product_selling.repository;
import product_selling.entity.Bag;
import product_selling.entity.Product;
import product_selling.entity.Tarp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static final String path = "src/product_selling/data/products.csv";

    public List<Product> getAllProducts() {
        return readFile();
    }

    private static List<Product> readFile() {
        List<Product> products = new ArrayList<>();

        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String[] data;
            int numOfItems;
            double numOfMeter;
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(",");
                if (data[0].trim().equalsIgnoreCase("Bao")) {
                    numOfItems = Integer.parseInt(data[5]);
                    products.add(new Bag(Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4]), numOfItems, data[6]));
                } else if (data[0].trim().equalsIgnoreCase("Bat")) {
                    numOfMeter = Double.parseDouble(data[5]);
                    products.add(new Tarp(Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4]), numOfMeter, data[6]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File không tìm thấy");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return products;
    }

    private static void writeFile(List<Product> products, boolean append) {
        try (FileWriter fileWriter = new FileWriter(path, append);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Product product : products) {
                bufferedWriter.write(product.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }

    public void addProduct(Product product) {
        List<Product> products = readFile();
        products.add(product);
        writeFile(products, false);
        System.out.println("Thêm thành công!");
    }

    public void deleteProduct(int id) {
        List<Product> products = readFile();
        products.removeIf(product -> product.getId() == id);
        writeFile(products, false);
    }

    public void editProduct(int id, String name, String collection, double price, double stock, String description) {
        List<Product> products = readFile();
        boolean found = false;

        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(name);
                p.setCollection(collection);
                p.setPrice(price);

                if (p instanceof Bag bag) {
                    bag.setNumberOfItems((int) stock);
                } else if (p instanceof Tarp tarp) {
                    tarp.setNumberOfMeters(stock);
                }

                p.setDescription(description);

                found = true;
                break;
            }
        }

        if (found) {
            writeFile(products, false);
            System.out.println("Cập nhật sản phẩm ID " + id + " thành công!");
        } else {
            System.out.println("Không tìm thấy sản phẩm có ID: " + id);
        }
    }

    public Product getProductById(int id) {
        List<Product> products = readFile();
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


    public boolean checkLoginAdmin(String username, String password) {
        final String ADMIN_USER = "admin";
        final String ADMIN_PASSWORD = "admin";
        return ADMIN_USER.equals(username) && ADMIN_PASSWORD.equals(password);
    }
}

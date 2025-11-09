package product_selling.repository;

import product_selling.controller.ProductController;
import product_selling.entity.*;

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

    public void addProduct(int productId, double quantity) {
        List<Product> products = readFile();
        Product found = null;

        for (Product p : products) {
            if (p.getId() == productId) {
                found = p;
                break;
            }
        }

        if (found == null) {
            System.out.println("Không tìm thấy sản phẩm có ID: " + productId);
            return;
        }

        double stock = 0;
        if (found instanceof Bag bag) {
            stock = bag.getNumberOfItems();
        } else if (found instanceof Tarp tarp) {
            stock = tarp.getNumberOfMeters();
        }

        if (quantity > stock) {
            System.out.println("Không đủ hàng! Chỉ còn " + stock);
            return;
        }

        List<CartItem> cart = readCartFile();
        double newTotal;

        boolean existed = false;
        for (CartItem item : cart) {
            if (item.getProduct().getId() == productId) {
                newTotal = item.getQuantity() + quantity;
                if (newTotal > stock) {
                    System.out.println("Không đủ hàng! Số sản phẩm còn lại " + stock + " (Đã có " + item.getQuantity() + " trong giỏ hàng)");
                    return;
                }

                item.setQuantity(newTotal);
                existed = true;
                break;
            }
        }

        if (!existed) {
            if (quantity > stock) {
                System.out.println("Không đủ hàng! Chỉ còn " + stock);
                return;
            }

            cart.add(new CartItem(found, quantity));
            System.out.println("Đã thêm sản phẩm vào giỏ hàng!");
        }

        writeFile(cart, false);
    }

    public List<Product> searchProductByName(String name) {
        List<Product> products = readFile();
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> searchProductByPrice(double price) {
        List<Product> products = readFile();
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() == price) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> searchProductByType(ProductType type) {
        List<Product> products = readFile();
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getType() == type) {
                result.add(product);
            }
        }
        return result;
    }
}

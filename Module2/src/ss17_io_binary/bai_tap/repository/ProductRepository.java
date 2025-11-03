package ss17_io_binary.bai_tap.repository;

import ss17_io_binary.bai_tap.entity.Product;
import ss17_io_binary.bai_tap.service.iProductService;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRepository {
    private final String path = "src/ss17_io_binary/bai_tap/data/products.dat";

    public boolean isDuplicateId(int id) {
        List<Product> products = readProductsFromFile();
        for (Product product : products) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product) {
        List<Product> products = readProductsFromFile();
        if (isDuplicateId(product.getId())) {
            return false;
        }
        products.add(product);
        writeProductsToFile(path, products);
        return true;
    }

    public List<Product> getAllProducts() {
        return readProductsFromFile();
    }

    public List<Product> searchProduct(String name) {
        List<Product> products = readProductsFromFile();
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }


    public List<Product> readProductsFromFile() {
        File file = new File(path);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (List<Product>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file");
        } catch (ClassNotFoundException e) {
            System.out.println("Khong tim thay class");
        } catch (IOException e) {
            System.out.println("Không đọc được file");
        }
        return new ArrayList<>();
    }

    public void writeProductsToFile(String path, List<Product> products) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }
}


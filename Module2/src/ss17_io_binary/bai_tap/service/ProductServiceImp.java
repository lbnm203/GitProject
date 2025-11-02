package ss17_io_binary.bai_tap.service;

import ss17_io_binary.bai_tap.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ProductServiceImp implements iProductService{
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

    @Override
    public boolean addProduct(Product product) {
        List<Product> products = readProductsFromFile();
        if (isDuplicateId(product.getId())) {
            return false;
        }
        products.add(product);
        writeProductsToFile(path, products);
        return true;
    }

    @Override
    public void displayAll() {
        List<Product> products = readProductsFromFile();
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

    @Override
    public void searchProduct(String name) {
        List<Product> products = readProductsFromFile();
        boolean isFound = false;
        StringBuilder sb = new StringBuilder();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                sb.append(String.format("%-5s %-20s %-15s %-15s %-20s \n", "ID", "Name", "Price", "Brand", "Description"));
                sb.append("-----------------------------------------------------------------------------\n");

                sb.append(String.format("%-5s %-20s %-15s %-15s %-20s\n",
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getBrand(),
                        product.getDescription()));
                isFound = true;
            }
            System.out.println(sb);
        }
        if (!isFound) {
            System.out.println("Khong tim thay san pham theo ten: " + name);
        }
    }

    @Override
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

    @Override
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

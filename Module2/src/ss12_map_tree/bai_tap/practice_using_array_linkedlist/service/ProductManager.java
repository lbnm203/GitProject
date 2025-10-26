package ss12_map_tree.bai_tap.practice_using_array_linkedlist.service;

import ss12_map_tree.bai_tap.practice_using_array_linkedlist.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductManager {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {

        products.add(product);
    }

    public boolean isDuplicateId(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void editProduct(int id, String newName, double newPrice) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(newName);
                product.setPrice(newPrice);
                return;
            }
        }

        System.out.println("Dont have product with id: " + id + "");
    }

    public void deleteProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                System.out.println("Delete successful ID: " + id);
                return;
            }
        }
    }

    public void showProducts() {
        if (products.isEmpty()) {
            System.out.println("List product is empty!");
            return;
        }

        System.out.printf("| %-5s | %-20s | %-10s |\n", "ID", "Name", "Price");
        System.out.println("----------------------------------------");

        for (Product product : products) {
            System.out.printf("|%-5d | %-20s | %-10.2f |\n", product.getId(), product.getName(), product.getPrice());
        }
        System.out.println("----------------------------------------");
    }

    public void searchProduct(String searchName) {
        if (products.isEmpty()) {
            System.out.println("List product is empty!");
            return;
        }

        for (Product product : products) {
            if (product.getName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.printf("| %-5s | %-20s | %-10s |\n", "ID", "Name", "Price");
                System.out.println("----------------------------------------");
                System.out.printf("|%-5d | %-20s | %-10.2f |\n", product.getId(), product.getName(), product.getPrice());
                return;
            }
        }
        System.out.println("Dont have product with name: " + searchName + "");
    }

    public void sortProductByPriceASC() {
        if (products.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            products.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return Double.compare(o1.getPrice(), o2.getPrice());
                }
            });
            System.out.println("Sort ASC successful!");
        }
    }

    public void sortProductByPriceDESC() {
        if (products.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            products.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return Double.compare(o2.getPrice(), o1.getPrice());
                }
            });
            System.out.println("Sort DESC successful!");
        }

    }

}

package ss12_map_tree.bai_tap.practice_using_array_linkedlist.repository;

import ss12_map_tree.bai_tap.practice_using_array_linkedlist.entity.Product;
import ss12_map_tree.bai_tap.practice_using_array_linkedlist.service.IProductService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class iProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Laptop", 1000000));
        products.add(new Product(2, "Phone", 10000));
        products.add(new Product(3, "Watch", 100000));
    }

    public boolean isDuplicateId(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (isDuplicateId(product.getId())) {
            return false;
        }
        products.add(product);
        return true;
    }



    public boolean deleteProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                return true;
            }
        }
        return false;
    }

    public boolean editProduct(int id, String newName, double newPrice) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(newName);
                product.setPrice(newPrice);
                return true;
            }
        }
        return false;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> findByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return Collections.singletonList(product);
            }
        }
        return null;
    }

    public List<Product> findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return Collections.singletonList(product);
            }
        }
        return null;
    }

    public List<Product> sortByPriceASC() {
        products.sort(Comparator.comparingDouble(Product::getPrice));
        return products;
    }

    public List<Product> sortByPriceDESC() {
        products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
        return products;
    }

}

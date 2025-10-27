package ss12_map_tree.bai_tap.practice_using_array_linkedlist.service;

import ss12_map_tree.bai_tap.practice_using_array_linkedlist.entity.Product;
import ss12_map_tree.bai_tap.practice_using_array_linkedlist.repository.iProductRepository;

import java.util.List;

public class ProductManager implements IProductService {
    private final iProductRepository products = new iProductRepository();

    @Override
    public boolean addProduct(Product product) {
        return products.addProduct(product);
    }

    @Override
    public boolean isDuplicateId(int id) {
        return products.isDuplicateId(id);
    }

    @Override
    public boolean editProduct(int id, String newName, double newPrice) {
        return products.editProduct(id, newName, newPrice);
    }

    @Override
    public List<Product> getAllProducts() {
        return products.getAllProducts();
    }

    @Override
    public List<Product> findByName(String name) {
        return products.findByName(name);
    }

    @Override
    public List<Product> sortByPriceASC() {
        return products.sortByPriceASC();
    }

    @Override
    public List<Product> sortByPriceDESC() {
        return products.sortByPriceDESC();
    }

    @Override
    public boolean deleteProduct(int id) {
        return products.deleteProduct(id);
    }

    @Override
    public List<Product> findById(int id) {
        return products.findById(id);
    }

//    public void showProducts() {
//        if (products.isEmpty()) {
//            System.out.println("List product is empty!");
//            return;
//        }
//
//        System.out.printf("| %-5s | %-20s | %-10s |\n", "ID", "Name", "Price");
//        System.out.println("----------------------------------------");
//
//        for (Product product : products) {
//            System.out.printf("|%-5d | %-20s | %-10.2f |\n", product.getId(), product.getName(), product.getPrice());
//        }
//        System.out.println("----------------------------------------");
//    }
//
//    public void searchProduct(String searchName) {
//        if (products.isEmpty()) {
//            System.out.println("List product is empty!");
//            return;
//        }
//
//        for (Product product : products) {
//            if (product.getName().toLowerCase().contains(searchName.toLowerCase())) {
//                System.out.printf("| %-5s | %-20s | %-10s |\n", "ID", "Name", "Price");
//                System.out.println("----------------------------------------");
//                System.out.printf("|%-5d | %-20s | %-10.2f |\n", product.getId(), product.getName(), product.getPrice());
//                return;
//            }
//        }
//        System.out.println("Dont have product with name: " + searchName + "");
//    }
//
//    public void sortProductByPriceASC() {
//        if (products.isEmpty()) {
//            System.out.println("List is empty!");
//        } else {
//            products.sort(new Comparator<Product>() {
//                @Override
//                public int compare(Product o1, Product o2) {
//                    return Double.compare(o1.getPrice(), o2.getPrice());
//                }
//            });
//            System.out.println("Sort ASC successful!");
//        }
//    }
//
//    public void sortProductByPriceDESC() {
//        if (products.isEmpty()) {
//            System.out.println("List is empty!");
//        } else {
//            products.sort(new Comparator<Product>() {
//                @Override
//                public int compare(Product o1, Product o2) {
//                    return Double.compare(o2.getPrice(), o1.getPrice());
//                }
//            });
//            System.out.println("Sort DESC successful!");
//        }
//
//    }

}

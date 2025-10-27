package ss12_map_tree.bai_tap.practice_using_array_linkedlist.service;

import ss12_map_tree.bai_tap.practice_using_array_linkedlist.entity.Product;

import java.util.List;

public interface IProductService {
    boolean addProduct(Product product);
    boolean deleteProduct(int id);
    boolean editProduct(int id, String newName, double newPrice);
    List<Product> getAllProducts();
    List<Product> findById(int id);
    boolean isDuplicateId(int id);
    List<Product> findByName(String name);
    List<Product> sortByPriceASC();
    List<Product> sortByPriceDESC();
}

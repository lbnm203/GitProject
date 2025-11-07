package product_selling.service;


import product_selling.common.exception.IdDuplicatedException;
import product_selling.entity.Product;

import java.util.List;

public interface iProductAdminService {
    List<Product> getAllProducts();
    boolean isDuplicateId(int id) throws IdDuplicatedException;
    void addProduct(Product p);
    void deleteProduct(int id);
    void editProduct(int id, String name, String collection, double price, double stock);
    void updateStock(int id, int newQuantity);
    Product findById(int id);

}

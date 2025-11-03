package ss17_io_binary.bai_tap.service;

import ss17_io_binary.bai_tap.entity.Product;

import java.util.List;

public interface iProductService {
    boolean isDuplicateId(int id);
    boolean addProduct(Product product);
    List<Product> getAllProducts();
    List<Product> searchProduct(String name);

}

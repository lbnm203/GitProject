package ss12_map_tree.bai_tap.practice_using_array_linkedlist.controller;
import ss12_map_tree.bai_tap.practice_using_array_linkedlist.entity.Product;
import ss12_map_tree.bai_tap.practice_using_array_linkedlist.service.IProductService;
import ss12_map_tree.bai_tap.practice_using_array_linkedlist.service.ProductManager;

import java.util.List;

public class ProductController{
    private final IProductService productService = new ProductManager();

    public boolean addProduct(Product product) {
        return productService.addProduct(product);
    }

    public boolean isDuplicateId(int id) {
        return productService.isDuplicateId(id);
    }

    public boolean editProduct(int id, String newName, double newPrice) {
        return productService.editProduct(id, newName, newPrice);
    }

    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    public List<Product> findByName(String name) {
        return productService.findByName(name);
    }

    public List<Product> sortByPriceASC() {
        return productService.sortByPriceASC();
    }

    public List<Product> sortByPriceDESC() {
        return productService.sortByPriceDESC();
    }

    public boolean deleteProduct(int id) {
        return productService.deleteProduct(id);
    }

    public List<Product> findById(int id) {
        return productService.findById(id);
    }
}

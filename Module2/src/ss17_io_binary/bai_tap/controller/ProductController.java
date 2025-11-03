package ss17_io_binary.bai_tap.controller;

import ss17_io_binary.bai_tap.entity.Product;
import ss17_io_binary.bai_tap.service.ProductService;
import ss17_io_binary.bai_tap.service.iProductService;

import java.util.List;

public class ProductController {
    private final iProductService productService = new ProductService();

    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    public boolean isDuplicateId(int id) {
        return productService.isDuplicateId(id);
    }

    public void addProduct(Product product) {
        productService.addProduct(product);
    }

    public List<Product> searchProduct(String keyword) {
        return productService.searchProduct(keyword);
    }
}

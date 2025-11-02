package ss17_io_binary.bai_tap.controller;

import ss17_io_binary.bai_tap.entity.Product;
import ss17_io_binary.bai_tap.service.ProductServiceImp;
import ss17_io_binary.bai_tap.service.iProductService;

public class ProductController {
    private final iProductService productService = new ProductServiceImp();

    public boolean isDuplicateId(int id) {
        return productService.isDuplicateId(id);
    }

    public void addProduct(Product product) {
        productService.addProduct(product);
    }

    public void displayAll() {
        productService.displayAll();
    }

    public void searchProduct(String keyword) {
        productService.searchProduct(keyword);
    }
}

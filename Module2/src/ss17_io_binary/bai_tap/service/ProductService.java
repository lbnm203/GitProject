package ss17_io_binary.bai_tap.service;

import ss17_io_binary.bai_tap.entity.Product;
import ss17_io_binary.bai_tap.repository.ProductRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ProductService implements iProductService{
    private final String path = "src/ss17_io_binary/bai_tap/data/products.dat";
    private final ProductRepository repository = new ProductRepository();

    @Override
    public boolean isDuplicateId(int id) {
        List<Product> products = repository.readProductsFromFile();
        for (Product product : products) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addProduct(Product product) {
        return repository.addProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.getAllProducts();
    }

    @Override
    public List<Product> searchProduct(String name) {
        return repository.searchProduct(name);
    }
}

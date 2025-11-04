package product_selling.service;

import product_selling.common.exception.IdDuplicatedException;
import product_selling.entity.Product;
import product_selling.repository.ProductRepository;

import java.util.List;

public class ProductAdminService implements iProductAdminService{
    private final ProductRepository repository = new ProductRepository();

    @Override
    public List<Product> getAllProducts() {
        return repository.getAllProducts();
    }

    @Override
    public boolean isDuplicateId(int id) throws IdDuplicatedException {
        List<Product> products = repository.getAllProducts();
        for (Product product : products) {
            if (product.getId() == id) {
                throw new IdDuplicatedException("Id trùng lặp!");
            }
        }
        return false;
    }

    @Override
    public void addProduct(Product p) {
        repository.addProduct(p);
    }

    @Override
    public void deleteProduct(int id) {
        repository.deleteProduct(id);
    }

    @Override
    public void editProduct(int id, String name, String collection, double price) {
        repository.editProduct(id, name, collection, price);
    }
}

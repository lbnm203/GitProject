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
    public void editProduct(int id, String name, String collection, double price, double stock, String description) {
        repository.editProduct(id, name, collection, price, stock, description);
    }

    @Override
    public boolean checkLoginAdmin(String username, String password) {
        return repository.checkLoginAdmin(username, password);
    }

    @Override
    public Product findById(int id) {
        return repository.getProductById(id);
    }


}

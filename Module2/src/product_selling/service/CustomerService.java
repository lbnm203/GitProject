package product_selling.service;

import product_selling.entity.Product;
import product_selling.entity.ProductType;
import product_selling.repository.CustomerRepository;

import java.util.List;

public class CustomerService implements iCustomerService{
    private final CustomerRepository repository = new CustomerRepository();

    @Override
    public void addToCart(int productId, double quantity) {
        repository.addProduct(productId, quantity);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return repository.searchProductByName(name);
    }

    @Override
    public List<Product> searchProductByPrice(double price) {
        return repository.searchProductByPrice(price);
    }

    @Override
    public List<Product> searchProductByType(ProductType type) {
        return repository.searchProductByType(type);
    }
}

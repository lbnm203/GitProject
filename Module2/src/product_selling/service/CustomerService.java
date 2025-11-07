package product_selling.service;

import product_selling.entity.Product;
import product_selling.repository.CustomerRepository;

public class CustomerService implements iCustomerService{
    private final CustomerRepository repository = new CustomerRepository();

    @Override
    public void addToCart(int productId, double quantity) {
        repository.addProduct(productId, quantity);
    }
}

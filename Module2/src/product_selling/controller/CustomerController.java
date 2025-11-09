package product_selling.controller;

import product_selling.entity.Product;
import product_selling.entity.ProductType;
import product_selling.service.CustomerService;

import java.util.List;

public class CustomerController {
    private CustomerService service = new CustomerService();

    public void addToCart(int productId, double quantity) {
        service.addToCart(productId, quantity);
    }

    public List<Product> searchProductByName(String name) {
        return service.searchProductByName(name);
    }

    public List<Product> searchProductByPrice(double price) {
        return service.searchProductByPrice(price);
    }

    public List<Product> searchProductByType(ProductType type) {
        return service.searchProductByType(type);
    }
}

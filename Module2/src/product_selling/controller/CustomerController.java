package product_selling.controller;

import product_selling.service.CustomerService;

public class CustomerController {
    private CustomerService service = new CustomerService();

    public void addToCart(int productId, double quantity) {
        service.addToCart(productId, quantity);
    }
}

package product_selling.service;

import product_selling.entity.Product;

public interface iCustomerService {
    public void addToCart(int productId, int quantity);
}

package product_selling.service;

import product_selling.entity.Product;
import product_selling.entity.ProductType;

import java.util.List;

public interface iCustomerService {
    public void addToCart(int productId, double quantity);
    List<Product> searchProductByName(String name);
    List<Product> searchProductByPrice(double price);
    List<Product> searchProductByType(ProductType type);
}

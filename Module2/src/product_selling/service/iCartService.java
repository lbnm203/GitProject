package product_selling.service;

import product_selling.entity.CartItem;

import java.util.List;

public interface iCartService {
    List<CartItem> getProductInCart();
    void removeFromCart(int id);
    void payCart();
    CartItem findById(int id);

}

package product_selling.controller;

import product_selling.entity.CartItem;
import product_selling.service.CartService;

import java.util.List;

public class CartController {
    private CartService service = new CartService();

    public List<CartItem> getProductInCart() {
        return service.getProductInCart();
    }
    public void removeFromCart(int id) {
        service.removeFromCart(id);
    }

    public CartItem findById(int id) {
        return service.findById(id);
    }

    public void payCart() {
        service.payCart();
    }

}

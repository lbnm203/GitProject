package product_selling.service;

import product_selling.entity.CartItem;
import product_selling.repository.CartRepository;

import java.util.List;

public class CartService implements iCartService{
    private final CartRepository repository = new CartRepository();

    @Override
    public List<CartItem> getProductInCart() {
        return repository.getProductInCart();
    }

    @Override
    public void removeFromCart(int id) {
        repository.removeFromCart(id);
    }

    @Override
    public void payCart() {
        repository.payCart();
    }

    @Override
    public CartItem findById(int id) {
        return repository.getCartItemById(id);
    }

}

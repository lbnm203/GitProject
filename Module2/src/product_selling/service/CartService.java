package product_selling.service;

import product_selling.repository.CartRepository;

public class CartService implements iCartService{
    private final CartRepository repository = new CartRepository();

    @Override
    public void removeFromCart(String id) {
        repository.deleteCartItem(id);
    }

    @Override
    public void payCart() {

    }
}

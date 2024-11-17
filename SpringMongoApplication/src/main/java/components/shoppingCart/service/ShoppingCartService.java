package components.shoppingCart.service;

import components.product.domain.Product;
import components.shoppingCart.domain.CartLine;
import components.shoppingCart.domain.ShoppingCart;
import components.shoppingCart.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public void add(ShoppingCart cart){
        shoppingCartRepository.save(cart);
    }
    public void addToCart(ShoppingCart cart, CartLine cartLine){
        cart.addToCart(cartLine);
        shoppingCartRepository.save(cart);
    }

    public ShoppingCart getShoppingCartByNumber(String cartNumber){
        return shoppingCartRepository.findByCartNumber(cartNumber);
    }
}

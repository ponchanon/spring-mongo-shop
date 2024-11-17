package shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private String cartNumber;
    private List<CartLine> cartLine = new ArrayList<>();

    public ShoppingCart(String cartNumber) {
        this.cartNumber = cartNumber;
    }

    public void addToCart(CartLine cartLine) {
        this.cartLine.add(cartLine);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartNumber=" + cartNumber +
                ", cartLine='" + cartLine + '\'' +
                '}';
    }

}

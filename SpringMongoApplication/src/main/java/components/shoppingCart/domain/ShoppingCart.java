package components.shoppingCart.domain;

import components.product.domain.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class ShoppingCart {
    @Id
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

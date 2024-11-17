package components.shoppingCart.domain;

import components.product.domain.Product;

public class CartLine {
    private Product product;
    private int quantity;

    public CartLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartLine{" +
                "quantity='" + this.quantity + '\'' +
                ", product='" + this.product + '\'' +
                '}';
    }
}

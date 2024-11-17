package components.product.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
    @Id
    private String productNumber;
    private String description;
    private double price;
    private Stock stock;
    private Supplier supplier;

    public Product(String productNumber, String description, double price, Stock stock, Supplier supplier) {
        this.productNumber = productNumber;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNumber=" + productNumber +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", stock='" + stock + '\'' +
                ", supplier=" + supplier +
                '}';
    }
}

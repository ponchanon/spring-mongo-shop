package components.product.service;

import components.product.domain.Product;

import java.util.Collection;
import java.util.List;

public interface IProductService {
    void add(Product product);

    List<Product> findAll();

    Product findByProductNumber(String name);
}

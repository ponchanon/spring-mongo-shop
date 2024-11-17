package components.product.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import components.product.domain.Product;
import components.product.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public void add(Product product){
        productRepository.save(product);
    }
    @Override
    public List<Product> findAll(){
         return productRepository.findAll();
    }
    @Override
    public Product findByProductNumber(String productNumber){
        return productRepository.findByProductNumber(productNumber);
    }
}

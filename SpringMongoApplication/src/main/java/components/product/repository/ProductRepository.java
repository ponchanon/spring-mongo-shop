package components.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import components.product.domain.Product;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {
    List<Product> findAll();
    @Query("{'productNumber' : ?0}")
    Product findByProductNumber(String productNumber);

}


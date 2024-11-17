package components.shoppingCart.repository;

import components.shoppingCart.domain.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, Integer> {
    @Query("{'cartNumber' : ?0}")
    ShoppingCart findByCartNumber(String cartNumber);

}



package components.product.controller;
import components.product.service.ProductService;
import components.error.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import components.product.domain.Product;

import java.util.Collection;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        productService.add(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts(){
        Collection<Product> products = (Collection<Product>) productService.findAll();
        //products.forEach(System.out::println);
        return new ResponseEntity<Collection<Product>>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{productNumber}")
    public ResponseEntity<?> getProduct(@PathVariable String productNumber){
        Product product = productService.findByProductNumber(productNumber);
        if(product == null){
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Product with product number " + productNumber + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
}

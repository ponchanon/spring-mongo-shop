package components.shoppingCart.controller;

import components.error.CustomErrorType;
import components.product.domain.Product;
import components.shoppingCart.domain.CartLine;
import components.shoppingCart.domain.ShoppingCart;
import components.shoppingCart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/shoppingCart")
    public ResponseEntity<?> addProduct(@RequestBody ShoppingCart cart){
        shoppingCartService.add(cart);
        return new ResponseEntity<ShoppingCart>(cart, HttpStatus.OK);
    }

    @PostMapping("/shoppingCart/{cartNumber}")
    public ResponseEntity<?> addToShoppingCart(@PathVariable String cartNumber, @RequestBody CartLine cartLine){
        ShoppingCart cart = shoppingCartService.getShoppingCartByNumber(cartNumber);
        if(cart == null){
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Cart with cart number " + cartNumber + " is not available"), HttpStatus.NOT_FOUND);
        }
        shoppingCartService.addToCart(cart, cartLine);
        return new ResponseEntity<ShoppingCart>(cart, HttpStatus.OK);
    }

    @GetMapping("/shoppingCart/{cartNumber}")
    public ResponseEntity<?> getShoppingCart(@PathVariable String cartNumber){
        ShoppingCart cart = shoppingCartService.getShoppingCartByNumber(cartNumber);
        if(cart == null){
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Cart with cart number " + cartNumber + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ShoppingCart>(cart, HttpStatus.OK);
    }

    @GetMapping("/hello2")
    public String sayHello2(){
        return "Hello World 2";
    }
}

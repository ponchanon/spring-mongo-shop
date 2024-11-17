package shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import shopping.*;

import java.util.Arrays;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {
	@Autowired
	private RestOperations restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String serverUrl = "http://localhost:8080/";

		Supplier supplier = new Supplier("S003", "Google", "pixel@google.com", "6412335878");
		Product product = new Product("P003", "Pixel 7", 900, new Stock(100, "IOWA"), supplier);

		restTemplate.postForLocation(serverUrl + "/products", product);
		// get pixel 7
		product = restTemplate.getForObject(serverUrl+"/products/{productNumber}", Product.class, "P003");
		System.out.println("----------- get Pixel 7-----------------------");
		System.out.println(product);
        // get all
		Product[] products = restTemplate.getForObject(serverUrl + "/products" , Product[].class);
		System.out.println("----------- get all products-----------------------");
		System.out.println(Arrays.toString(products));

		// create shopping cart
		String cartNumber = "cart002";
		ShoppingCart cart = new ShoppingCart(cartNumber);
		restTemplate.postForLocation(serverUrl + "/shoppingCart", cart);
		restTemplate.postForLocation(serverUrl + "/shoppingCart/{cartNumber}", cartNumber, new CartLine(product, 2));
		cart = restTemplate.getForObject(serverUrl + "/shoppingCart/{cartNumber}", ShoppingCart.class, cartNumber);
		System.out.println(cart);
	}


	@Bean
	RestOperations restTemplate() {
		return new RestTemplate();
	}
}

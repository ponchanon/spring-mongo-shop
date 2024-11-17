package components;

import components.customer.domain.Address;
import components.customer.domain.Student;
import components.customer.repository.StudentRepository;
import components.product.domain.Product;
import components.product.domain.Stock;
import components.product.domain.Supplier;
import components.product.service.ProductService;
import components.shoppingCart.domain.CartLine;
import components.shoppingCart.domain.ShoppingCart;
import components.shoppingCart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ProductService productService;
	@Autowired
	private ShoppingCartService shoppingCartService;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Running ...");
	}

	@Override
	public void run(String... args) throws Exception {

		// create student
//		Student student = new Student(101,"John doe", "johnd@acme.com", "0622341678");
//		Address address = new Address("4th street", "Fairfield", "52557");
//		student.setAddress(address);
//		studentRepository.save(student);
//		student = new Student(109,"John Jones", "jones@acme.com", "0624321234");
//		student.setAddress(address);
//		studentRepository.save(student);
//		student = new Student(66,"James Johnson", "jj123@acme.com", "068633452");
//		address = new Address("5th street", "Fairfield", "52558");
//		student.setAddress(address);
//		studentRepository.save(student);
//
//		System.out.println("-----------All students ----------------");
//		System.out.println(studentRepository.findAll());
//		System.out.println("-----------find all by name ----------------");
//		List<Student> students = studentRepository.findAllByName("John Jones");
//		for (Student std : students){
//			System.out.println(std);
//		}
//		System.out.println("-----------find by phone ----------------");
//		System.out.println(studentRepository.findByPhone("068633452"));
//		System.out.println("-----------find all by city ----------------");
//		students = studentRepository.findAllByCity("Fairfield");
//		for (Student std : students){
//			System.out.println(std);
//		}

		// create product
//		Supplier supplier = new Supplier("S001", "Apple", "apple@apple.com", "6412335656");
		Supplier supplier2 = new Supplier("S002", "Samsung", "samsung@samsung.com", "6412335888");
////		Product product = new Product("P002", "IPhone 14", 1200, 100, "IOWA", supplier);
//		productService.add(product);

		Product product = new Product("P003", "Samsung galaxy S23", 1300, new Stock(50, "IOWA"), supplier2);
		productService.add(product);
		ShoppingCart cart = new ShoppingCart("cart001");
		shoppingCartService.add(cart);
		shoppingCartService.addToCart(cart, new CartLine(product, 2));
		cart = shoppingCartService.getShoppingCartByNumber("cart001");
		System.out.println(cart);
	}

}

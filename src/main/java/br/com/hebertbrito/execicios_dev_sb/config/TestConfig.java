package br.com.hebertbrito.execicios_dev_sb.config;


import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.hebertbrito.execicios_dev_sb.entities.Category;
import br.com.hebertbrito.execicios_dev_sb.entities.Order;
import br.com.hebertbrito.execicios_dev_sb.entities.Product;
import br.com.hebertbrito.execicios_dev_sb.entities.User;
import br.com.hebertbrito.execicios_dev_sb.entities.enums.OrderStatus;
import br.com.hebertbrito.execicios_dev_sb.repositories.CategoryRepository;
import br.com.hebertbrito.execicios_dev_sb.repositories.OrderRepository;
import br.com.hebertbrito.execicios_dev_sb.repositories.ProductRepository;
import br.com.hebertbrito.execicios_dev_sb.repositories.UserRepository;

@Configuration // -> ANOTAÇAO PARA CLASSE ESPECIFICA DE CONFIGURAÇÃO;
@Profile("test") // -> ANOTAÇÃO DE CONFIGURAÇÃO ESPECIFICA PARA O PERFIL DE TESTE;
public class TestConfig implements CommandLineRunner {
	/*
	 * CLASSE DE CONFIGURAÇÃO ESPECIFICA PARA O PERFIL DE TESTE ESSA CLASSE É UMA
	 * CLASSE AUXILIAR (NAO É CONTROLLER, SERVICE NEM REPOSITORY) QUE VAI FAZER
	 * ALGUMAS CONFIGURAÇÕES NA APLICAÇÃO,
	 */
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);//NOTA: "U1" ESTA SENDO PASSADO, ASSIM FAZ A ASSOCIAÇAO ENTRE OS OBJETOS
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAITING_PAYMENT); 
		//->  ISO 8601 FORMATO DE DATA "2019-07-22T15:21:22Z" PADRAO UTC 
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));//-> RECEBE QUALQUE OBJ QUE SEJA ITERAVEL (AQUI NO CADO UM ARRAY)
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}

}

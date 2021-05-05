package io.rahul.product;

import io.rahul.product.domain.model.Product;
import io.rahul.product.domain.value_objects.Currency;
import io.rahul.product.domain.value_objects.Money;
import io.rahul.product.infrastructure.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		Product iphone = Product.builder()
				.id(UUID.randomUUID().toString())
				.name("IPhone 11")
				.price(Money.builder().value(49999).currency(Currency.INR).build())
				.code("IPHONE11")
				.quantity(10).build();

		Product samsung = Product.builder()
				.id(UUID.randomUUID().toString())
				.name("Samsung Galaxy S11")
				.price(Money.builder().value(79999).currency(Currency.INR).build())
				.code("GALAXY11")
				.quantity(5).build();

		List<Product> productList = new ArrayList<>();
		productList.add(iphone);
		productList.add(samsung);
		productRepository.saveAll(productList);
	}
}

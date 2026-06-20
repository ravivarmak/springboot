package ravi.varma.Microservices1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ravi.varma.Microservices1.dto.Product;

@RestController
public class ProductController {
	List<Product> products = new ArrayList<>();

	@PostMapping("/products") 
	public String addProduct(@RequestBody Product product) {
		products.add(product);
		return "Product added successfully";
	}
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return products;
	}

	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable int id) {
		for (Product product : products) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}
}

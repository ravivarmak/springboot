package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.Product;
import com.example.jpa.projection.ProductView;
import com.example.jpa.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}
	@GetMapping("/products/pagination")
	public List<Product> getProductsByPagination(@RequestParam int page, @RequestParam int size) {
		return productService.getProductsByPagination(page, size);
	}
	@PostMapping("/products/transactional")
	public Product addProduct(@RequestBody Product product, @RequestParam boolean failureFlag) {
		return productService.createProduct(product, failureFlag);
	}
	@GetMapping("/products/category")
	public List<ProductView> getProductsByCategory(@RequestParam String category) {
		return productService.getProductsByCategory(category);
	}
}

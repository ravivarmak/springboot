package com.example.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.entity.Product;
import com.example.jpa.projection.ProductView;
import com.example.jpa.repo.ProductRepository;
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}


	public Product createProduct(Product product) {
		// Ensure we don't accidentally treat client-sent id as an update
		product.setCategory(null);
		return productRepository.save(product);
	}


	public Product updateProduct(int id, Product product) {
		Product existing = productRepository.findById(id)
				.orElseThrow(() -> new org.springframework.web.server.ResponseStatusException(
						org.springframework.http.HttpStatus.NOT_FOUND, "Product not found with id " + id));
		existing.setName(product.getName());
		existing.setPrice(product.getPrice());
		existing.setCategory(product.getCategory());
		// Do not copy version from detached instance; let JPA manage it
		return productRepository.save(existing);
	}
	public List<Product> getProductsByPagination(int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("name").descending());
		Page<Product> productPage = productRepository.findAll(pageable);
		// select * from products order by name desc limit size offset page*size;
		
		System.out.println(productPage);
		
		return productPage.getContent(); 
	}
	@Transactional
	public Product createProduct(Product product, boolean triggerFailure) {
		// Ensure we don't accidentally treat client-sent id as an update
		product.setCategory(null);
		Product savedProduct = productRepository.save(product);
		if (triggerFailure) {
			// Simulate an error after save to demonstrate transactional rollback
			throw new RuntimeException("Simulated error occurred after saving " + product.getName());
		}

		return savedProduct;
	}
	public List<ProductView> getProductsByCategory(String category) {
		return productRepository.findByCategory(category);
	}
}

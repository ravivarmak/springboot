package ravi.varma.postgre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ravi.varma.postgre.entity.Product;

interface  ProductRepository extends JpaRepository<Product, Long> {
//Derived Query Methods
	List<Product> findByCategory(String category);
	List<Product> findByPriceGreaterThan(Double price);
	List<Product> findByNameContaining(String keyword);
}

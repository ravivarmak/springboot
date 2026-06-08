package com.example.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Product;
import com.example.jpa.projection.ProductView;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	//Naming Rule: findBy + Property + Condition	
		List<Product> findByName(String name);
		
		List<Product> findByPriceLessThan(Double price);
		Product findFirstByOrderByPriceDesc();
		//Product findFirstByPriceDesc();
		// JPQL vs Native SQL
		@Query("SELECT p FROM Product p WHERE p.category = :category")
		List<Product> findByCategoryJPQL(@Param("category") String category);

		//@Query(value = "SELECT * FROM products WHERE category = :category", nativeQuery = true)
		@NativeQuery("SELECT * FROM products WHERE category = :category")
		List<Product> findByCategoryNative(@Param("category") String category);
		//Projection
		List<ProductView> findByCategory(String category);
		// select name, price from products;
		
}

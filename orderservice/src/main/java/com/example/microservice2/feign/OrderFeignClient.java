package com.example.microservice2.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservice2.dto.Product;
@FeignClient(name = "microservice1", url = "http://localhost:8081")
public interface OrderFeignClient {
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable int id);
}

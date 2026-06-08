package com.example.microservice2.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.microservice2.dto.Product;
import com.example.microservice2.feign.OrderFeignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class OrderController {
	private final WebClient webClient;
	private final OrderFeignClient feignClient;
	public OrderController(WebClient.Builder webClientBuilder, OrderFeignClient feignClient) {
		this.webClient = webClientBuilder.build();
		this.feignClient = feignClient;
	}
	
	@CircuitBreaker(name = "microservice1", fallbackMethod = "fallbackGetOrderById")
	@GetMapping("/orders/product/{id}")
	public String getOrderById(@PathVariable int id) {
		if(new Random().nextBoolean()) {
			throw new RuntimeException("Simulated service failure");
		}
		/*
		 * Product p = webClient.get() //https://localhost:8081/products/1
		 * .uri("http://microservice1/products/" + id) .retrieve()
		 * .bodyToMono(Product.class) .block();
		 */
		Product p = feignClient.getProductById(id);
		System.out.println("Product retrieved with Id: " + p.getId());
		return "Ordered the product: " + p.getName() + " with price: " + p.getPrice();
		//return feignClient.getProductById(id);
	}
	public String fallbackGetOrderById(int id, Exception t) {
		System.out.println("Fallback executed: " + t.getMessage());
		return "Circuit breaker fallback: Unable to retrieve product with id: " + id;
	}
}

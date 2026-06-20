package ravi.varma.Microservices2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ravi.varma.Microservices2.dto.Product;
import ravi.varma.Microservices2.feign.OrderFeignClient;
//import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class OrderController {

	//private final WebClient webClient;
	private final OrderFeignClient feignClient;
	public OrderController( OrderFeignClient feignClient) {
		//this.webClient = webClientBuilder.build();
		this.feignClient = feignClient;
	}
	@GetMapping("/orders/product/{id}")
	public String getOrderById(@PathVariable int id) {

		Product p = feignClient.getProductById(id);
		
		System.out.println("Product retrieved with Id: " + p.getId());
		return "Order successfully placed for product: " + p.getName() + " with price: " + p.getPrice();
	}
}

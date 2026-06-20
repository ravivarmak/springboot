package ravi.varma.Microservices2.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ravi.varma.Microservices2.dto.Product;

@FeignClient(name = "Microservices1")
public interface OrderFeignClient {

	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable int id);
}

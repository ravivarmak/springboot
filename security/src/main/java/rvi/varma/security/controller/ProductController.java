package rvi.varma.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import rvi.varma.security.entity.Users;
import rvi.varma.security.service.UserService;

@RestController
public class ProductController {
	@Autowired
	private UserService service;
	@GetMapping("/hello")
	public String hello() {
		return "Hello, World!";
	}
	@GetMapping("/users")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Users> getAllUsers() {
		return service.getAllUsers();
	}
}

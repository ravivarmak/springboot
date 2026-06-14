package rvi.varma.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rvi.varma.security.dto.LoginDTO;
import rvi.varma.security.dto.RegisterDTO;
import rvi.varma.security.entity.Users;
import rvi.varma.security.service.AuthService;
import rvi.varma.security.service.JwtService;

@RestController
public class AuthController {
	@Autowired
	private AuthService authService;
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/register")
	public Users register(@RequestBody RegisterDTO register) {
		return authService.register(register);
	}
	@PostMapping("/login")
	public String login(@RequestBody LoginDTO loginDto) {
		Users user = authService.login(loginDto);
		if (user == null) {
			return "Invalid credentials";
		} else {
			return jwtService.generateToken(user);
		}
	}
	@GetMapping("/greet")
	public String hello() {
		return "Hello";
	}
	
}

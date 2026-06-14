package rvi.varma.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rvi.varma.security.dto.LoginDTO;
import rvi.varma.security.dto.RegisterDTO;
import rvi.varma.security.entity.Users;
import rvi.varma.security.repository.UserRepository;

@Service
public class AuthService {
	@Autowired
	private UserRepository repo;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private AuthenticationManager authenticationManager;

	public Users register(RegisterDTO register) {
		Users user = new Users();
		user.setName(register.getName());
		user.setEmail(register.getEmail());
		user.setPassword(encoder.encode(register.getPassword()));
		user.setRole(register.getRole());
		return repo.save(user);
	}
	public Users login(LoginDTO input) {
		Users user = repo.findByEmail(input.getEmail());

		if (user != null && encoder.matches(input.getPassword(), user.getPassword())) {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(
							input.getEmail(), input.getPassword()));
			return user;
		}
		return null;
	}
}

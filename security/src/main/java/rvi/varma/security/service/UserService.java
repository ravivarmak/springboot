package rvi.varma.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rvi.varma.security.entity.Users;
import rvi.varma.security.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	public UserRepository repo;
	
	public List<Users> getAllUsers() {
		return repo.findAll();
	}
	
	public Users getUserById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
}

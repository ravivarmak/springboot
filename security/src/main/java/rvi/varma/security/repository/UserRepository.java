package rvi.varma.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rvi.varma.security.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	Users findByEmail(String email);

}

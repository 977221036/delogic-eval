package br.com.delogic.ticketExchange.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.delogic.ticketExchange.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
	
}

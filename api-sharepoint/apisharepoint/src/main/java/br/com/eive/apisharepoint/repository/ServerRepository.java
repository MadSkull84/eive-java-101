package br.com.eive.apisharepoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eive.apisharepoint.model.Server;

public interface ServerRepository extends JpaRepository<Server, Long> {
	
	List<Server> findByCustomerId(Long id);
	
}

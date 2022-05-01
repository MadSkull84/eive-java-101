package br.com.eive.apisharepoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eive.apisharepoint.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByCustomerId(Long id);
	
}

package br.com.eive.apisharepoint.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eive.apisharepoint.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	List<Customer> findByName(String name);
	Optional<Customer> findById(Long id);
}

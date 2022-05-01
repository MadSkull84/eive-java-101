package br.com.eive.apisharepoint.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eive.apisharepoint.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	List<Contact> findByCustomerId(Long id);	
	Optional<Contact> findByCustomerIdAndMainTrue(Long customerId);
	List<Contact> findByCustomerIdInAndMainTrue(Iterable<Long> custumersId);
	
}

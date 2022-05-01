package br.com.eive.apisharepoint.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.eive.apisharepoint.dto.ContactDTO;
import br.com.eive.apisharepoint.dto.CustomerDTO;
import br.com.eive.apisharepoint.dto.CustomersDTO;
import br.com.eive.apisharepoint.model.Contact;
import br.com.eive.apisharepoint.model.Customer;
import br.com.eive.apisharepoint.repository.ContactRepository;
import br.com.eive.apisharepoint.repository.CustomerRepository;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@GetMapping
	public ResponseEntity<List<CustomersDTO>> findByName(@RequestParam(name = "name") Optional<String> name) {
		List<Customer> customers;
		if (!name.isPresent()) {
			customers = customerRepository.findAll();
		} else {
			customers = customerRepository.findByName(name.get());
		}
		
		List<Contact> contacts = contactRepository
				.findByCustomerIdInAndMainTrue(customers.stream().map(Customer::getId).collect(Collectors.toList()));		
		
		List<CustomersDTO> customersDTO = CustomersDTO.convertAll(customers);
		
		customersDTO.forEach(customerDTO -> {
			Optional<Contact> contactMain = contacts.stream()
					.filter(contact -> contact.getCustomer().getId() == customerDTO.getId()).findFirst();
			if (contactMain.isPresent()) {
				customerDTO.setContact(new ContactDTO(contactMain.get()));
			}
		});
		
		if (customers.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(customersDTO);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> findById(@PathVariable Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			return ResponseEntity.ok(new CustomerDTO(customer.get()));
		}		
		return ResponseEntity.noContent().build();
	}	
	
	@PostMapping
	@Transactional
	public ResponseEntity<CustomerDTO> insertCustumer(@RequestBody @Valid CustomerDTO customerDTO, UriComponentsBuilder uriBuilder) {
		Customer customer = CustomerDTO.convert(customerDTO);
		customerRepository.save(customer);		
		URI uri = uriBuilder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri();
		return ResponseEntity.created(uri).body(new CustomerDTO(customer));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CustomerDTO> updateCustumer(@PathVariable Long id, @RequestBody @Valid CustomerDTO customerDTO, UriComponentsBuilder uriBuilder) {
		Optional<Customer> customer = customerRepository.findById(id); 
		if (customer.isPresent()) {
			customerDTO.update(customer.get());
			customerRepository.save(customer.get());
			URI uri = uriBuilder.path("/customer/{id}").buildAndExpand(customer.get().getId()).toUri();
			return ResponseEntity.created(uri).body(new CustomerDTO(customer.get()));				
		}
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			customerRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.noContent().build();
	}	
}

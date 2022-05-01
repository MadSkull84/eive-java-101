package br.com.eive.apisharepoint.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.eive.apisharepoint.dto.ContactDTO;
import br.com.eive.apisharepoint.model.Contact;
import br.com.eive.apisharepoint.model.Customer;
import br.com.eive.apisharepoint.repository.ContactRepository;
import br.com.eive.apisharepoint.repository.CustomerRepository;
import br.com.eive.apisharepoint.validation.dto.CustomFormErrorDTO;

@CrossOrigin
@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/customer/{id}")
	public ResponseEntity<List<ContactDTO>> findByCustomerId(@PathVariable Long id) {
		List<Contact> contacts = contactRepository.findByCustomerId(id);
		if (contacts.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(ContactDTO.convertAll(contacts));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> insertContact(@RequestBody @Valid ContactDTO contactDTO, UriComponentsBuilder uriBuilder) {
		Optional<Customer> customer = customerRepository.findById(contactDTO.getCustomerId());
		if (!customer.isPresent()) {
			return ResponseEntity.internalServerError().body(new CustomFormErrorDTO("customerId", "não encontrado"));
		}
		Contact contact = ContactDTO.convert(contactDTO);
		contactRepository.save(contact);
		URI uri = uriBuilder.path("contact/customer/{id}").buildAndExpand(contact.getCustomer().getId()).toUri();
		return ResponseEntity.created(uri).body(new ContactDTO(contact));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> updateContact(@PathVariable Long id, @RequestBody @Valid ContactDTO contactDTO, UriComponentsBuilder uriBuilder) {		
		Optional<Contact> contact = contactRepository.findById(id);
		if (!contact.isPresent()) {
			return ResponseEntity.noContent().build();	
		}
		Optional<Customer> customer = customerRepository.findById(contactDTO.getCustomerId());
		if (!customer.isPresent()) {
			return ResponseEntity.internalServerError().body(new CustomFormErrorDTO("customerId", "não encontrado"));
		}		
		contactDTO.update(contact.get(), customer.get());
		contactRepository.save(contact.get());
		URI uri = uriBuilder.path("contact/customer/{id}").buildAndExpand(contact.get().getCustomer().getId()).toUri();
		return ResponseEntity.created(uri).body(new ContactDTO(contact.get()));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleteContact(@PathVariable Long id) {
		Optional<Contact> contact = contactRepository.findById(id);
		if (contact.isPresent()) {
			contactRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.noContent().build();
	}		

}

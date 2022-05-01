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

import br.com.eive.apisharepoint.dto.ServerDTO;
import br.com.eive.apisharepoint.model.Customer;
import br.com.eive.apisharepoint.model.Server;
import br.com.eive.apisharepoint.repository.CustomerRepository;
import br.com.eive.apisharepoint.repository.ServerRepository;
import br.com.eive.apisharepoint.validation.dto.CustomFormErrorDTO;

@CrossOrigin
@RestController
@RequestMapping("/server")
public class ServerController {
	
	@Autowired
	private ServerRepository serverRepository;

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<List<ServerDTO>> findByCustomerId(@PathVariable Long id) {
		List<Server> servers = serverRepository.findByCustomerId(id);
		if (servers.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(ServerDTO.convertAll(servers));
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> insertServer(@RequestBody @Valid ServerDTO serverDTO, UriComponentsBuilder uriBuilder) {
		Optional<Customer> customer = customerRepository.findById(serverDTO.getCustomerId());
		if (!customer.isPresent()) {
			return ResponseEntity.internalServerError().body(new CustomFormErrorDTO("customerId", "não encontrado"));
		}
		Server server = ServerDTO.convert(serverDTO);
		serverRepository.save(server);
		URI uri = uriBuilder.path("contact/customer/{id}").buildAndExpand(server.getCustomer().getId()).toUri();
		return ResponseEntity.created(uri).body(new ServerDTO(server));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> updateServer(@PathVariable Long id, @RequestBody @Valid ServerDTO serverDTO, UriComponentsBuilder uriBuilder) {		
		Optional<Server> server = serverRepository.findById(id);
		if (!server.isPresent()) {
			return ResponseEntity.noContent().build();	
		}
		Optional<Customer> customer = customerRepository.findById(serverDTO.getCustomerId());
		if (!customer.isPresent()) {
			return ResponseEntity.internalServerError().body(new CustomFormErrorDTO("customerId", "não encontrado"));
		}		
		serverDTO.update(server.get(), customer.get());
		serverRepository.save(server.get());
		URI uri = uriBuilder.path("contact/customer/{id}").buildAndExpand(server.get().getCustomer().getId()).toUri();
		return ResponseEntity.created(uri).body(new ServerDTO(server.get()));				
				
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleteServer(@PathVariable Long id) {
		Optional<Server> server = serverRepository.findById(id);
		if (server.isPresent()) {
			serverRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.noContent().build();
	}		

}

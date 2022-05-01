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

import br.com.eive.apisharepoint.dto.ProductDTO;
import br.com.eive.apisharepoint.model.Customer;
import br.com.eive.apisharepoint.model.Product;
import br.com.eive.apisharepoint.repository.CustomerRepository;
import br.com.eive.apisharepoint.repository.ProductRepository;
import br.com.eive.apisharepoint.validation.dto.CustomFormErrorDTO;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<List<ProductDTO>> findByCustomerId(@PathVariable Long id) {
		List<Product> products = productRepository.findByCustomerId(id);
		if (products.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(ProductDTO.convertAll(products));
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> insertProduct(@RequestBody @Valid ProductDTO productDTO, UriComponentsBuilder uriBuilder) {
		Optional<Customer> customer = customerRepository.findById(productDTO.getCustomerId());
		if (!customer.isPresent()) {
			return ResponseEntity.internalServerError().body(new CustomFormErrorDTO("customerId", "não encontrado"));
		}
		Product product = ProductDTO.convert(productDTO);
		productRepository.save(product);
		URI uri = uriBuilder.path("product/customer/{id}").buildAndExpand(product.getCustomer().getId()).toUri();
		return ResponseEntity.created(uri).body(new ProductDTO(product));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductDTO productDTO, UriComponentsBuilder uriBuilder) {		
		Optional<Product> product = productRepository.findById(id);
		if (!product.isPresent()) {
			return ResponseEntity.noContent().build();	
		}
		Optional<Customer> customer = customerRepository.findById(productDTO.getCustomerId());
		if (!customer.isPresent()) {
			return ResponseEntity.internalServerError().body(new CustomFormErrorDTO("customerId", "não encontrado"));
		}		
		productDTO.update(product.get(), customer.get());
		productRepository.save(product.get());
		URI uri = uriBuilder.path("product/customer/{id}").buildAndExpand(product.get().getCustomer().getId()).toUri();
		return ResponseEntity.created(uri).body(new ProductDTO(product.get()));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			productRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.noContent().build();
	}	

}

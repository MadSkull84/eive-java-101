package br.com.eive.apisharepoint.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.eive.apisharepoint.model.Customer;
import br.com.eive.apisharepoint.model.Product;

public class ProductDTO {

	private Long id;
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 255)	
	private String name;
	@Size(max = 4000)
	private String notes;
	@DateTimeFormat
	private LocalDate acquisitionDate;
	@Positive
	private Long customerId;

	public ProductDTO() {
	}

	public ProductDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.notes = product.getNotes();
		this.acquisitionDate = product.getAcquisitionDate();
		this.customerId = product.getCustomer().getId();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNotes() {
		return notes;
	}

	public LocalDate getAcquisitionDate() {
		return acquisitionDate;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	
	public static List<ProductDTO> convertAll(List<Product> product) {
		return product.stream().map(ProductDTO::new).collect(Collectors.toList());
	}

	public static Product convert(ProductDTO productDTO) {
		return new Product(productDTO.getName(), productDTO.getNotes(), productDTO.getAcquisitionDate(), new Customer(productDTO.getCustomerId()));
	}

	public void update(Product product, Customer customer) {
		product.setName(this.name);
		product.setNotes(this.notes);
		product.setAcquisitionDate(this.acquisitionDate);
		product.setCustomer(customer);
	}	

}

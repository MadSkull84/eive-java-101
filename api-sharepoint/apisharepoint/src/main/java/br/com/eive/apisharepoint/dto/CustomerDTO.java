package br.com.eive.apisharepoint.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.eive.apisharepoint.model.Customer;

public class CustomerDTO {

	private Long id;
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 255)
	private String name;
	@Size(max = 4000)
	private String notes;
	@Size(max = 4000)
	private String dbInfo;
	private Boolean usesVpn;
	private Boolean usesNewIntegration;
	@NotNull
	@NotEmpty
	@Pattern(regexp = "^[ABC]$", message = "valor informado não atende aos requisitos")
	private String tier;
	@Size(max = 36)
	private String segment;
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 80)
	private String responsible;

	public CustomerDTO() {
	}

	public CustomerDTO(Customer customer) {
		this.id = customer.getId();
		this.name = customer.getName();
		this.notes = customer.getNotes();
		this.dbInfo = customer.getDbInfo();
		this.usesVpn = customer.getUsesVpn();
		this.usesNewIntegration = customer.getUsesNewIntegration();
		this.tier = customer.getTier();
		this.segment = customer.getSegment();
		this.responsible = customer.getResponsible();
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

	public String getDbInfo() {
		return dbInfo;
	}

	public Boolean getUsesVpn() {
		return usesVpn;
	}

	public Boolean getUsesNewIntegration() {
		return usesNewIntegration;
	}

	public String getTier() {
		return tier;
	}

	public String getSegment() {
		return segment;
	}

	public String getResponsible() {
		return responsible;
	}

	public static List<CustomerDTO> convertAll(List<Customer> customers) {
		return customers.stream().map(CustomerDTO::new).collect(Collectors.toList());
	}

	public static Customer convert(CustomerDTO customerDTO) {
		return new Customer(customerDTO.getName(), customerDTO.getNotes(), customerDTO.getDbInfo(),
				customerDTO.getUsesVpn(), customerDTO.getUsesNewIntegration(), customerDTO.getTier(),
				customerDTO.getSegment(), customerDTO.getResponsible());
	}

	public void update(Customer customer) {
		customer.setName(this.name);
		customer.setNotes(this.notes);
		customer.setDbInfo(this.dbInfo);
		customer.setUsesVpn(this.usesVpn);
		customer.setUsesNewIntegration(this.usesNewIntegration);
		customer.setTier(this.tier);
		customer.setSegment(this.segment);
		customer.setResponsible(this.responsible);
	}

}

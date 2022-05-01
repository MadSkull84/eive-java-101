package br.com.eive.apisharepoint.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.eive.apisharepoint.model.Customer;

public class CustomersDTO {

	private Long id;
	private String name;
	private String notes;
	private String dbInfo;
	private Boolean usesVpn;
	private Boolean usesNewIntegration;
	private String tier;
	private String segment;
	private String responsible;
	private ContactDTO contact;

	public CustomersDTO() {
	}
	
	public CustomersDTO(Customer customer) {
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

	public ContactDTO getContact() {
		return contact;
	}

	public void setContact(ContactDTO contact) {
		this.contact = contact;
	}
	
	public static List<CustomersDTO> convertAll(List<Customer> customers) {
		return customers.stream().map(CustomersDTO::new).collect(Collectors.toList());
	}

}

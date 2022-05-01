package br.com.eive.apisharepoint.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.eive.apisharepoint.model.Contact;
import br.com.eive.apisharepoint.model.Customer;

public class ContactDTO {

	private Long id;
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 255)
	private String name;
	@Size(max = 500)
	private String email;
	@Size(max = 50)
	private String phone;
	@Size(max = 50)
	private String cellphone;	
	private Boolean main;
	@Positive
	private Long customerId;

	public ContactDTO() {

	}

	public ContactDTO(Contact contact) {
		this.id = contact.getId();
		this.name = contact.getName();
		this.email = contact.getEmail();
		this.phone = contact.getPhone();
		this.cellphone = contact.getCellphone();
		this.main = contact.getMain();
		this.customerId = contact.getCustomer().getId();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public Boolean getMain() {
		return main;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public static List<ContactDTO> convertAll(List<Contact> contacts) {
		return contacts.stream().map(ContactDTO::new).collect(Collectors.toList());
	}

	public static Contact convert(ContactDTO contactDTO) {
		return new Contact(contactDTO.getName(), contactDTO.getEmail(), contactDTO.getPhone(),
				contactDTO.getCellphone(), contactDTO.getMain(), new Customer(contactDTO.getCustomerId()));
	}
	
	public void update(Contact contact, Customer customer) {
		contact.setName(this.name);
		contact.setEmail(this.email);
		contact.setPhone(this.phone);
		contact.setCellphone(this.cellphone);
		contact.setMain(this.main);
		contact.setCustomer(customer);
	}	

}

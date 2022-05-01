package br.com.eive.apisharepoint.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.eive.apisharepoint.model.Customer;
import br.com.eive.apisharepoint.model.Server;

public class ServerDTO {

	private Long id;
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 255)
	private String ip;
	@Size(max = 255)
	private String dns;
	@Size(max = 255)
	private String login;
	@Size(max = 255)
	private String password;
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 255)
	private String name;
	@Size(max = 4000)
	private String notes;
	@Positive
	private Long customerId;

	public ServerDTO() {
	}

	public ServerDTO(Server server) {
		this.id = server.getId();
		this.ip = server.getIp();
		this.dns = server.getDns();
		this.login = server.getLogin();
		this.password = server.getPassword();
		this.name = server.getName();
		this.notes = server.getNotes();
		this.customerId = server.getCustomer().getId();
	}

	public Long getId() {
		return id;
	}

	public String getIp() {
		return ip;
	}

	public String getDns() {
		return dns;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getNotes() {
		return notes;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public static List<ServerDTO> convertAll(List<Server> servers) {
		return servers.stream().map(ServerDTO::new).collect(Collectors.toList());
	}

	public static Server convert(ServerDTO serverDTO) {
		return new Server(serverDTO.getIp(), serverDTO.getDns(), serverDTO.getLogin(), serverDTO.getPassword(),
				serverDTO.getName(), serverDTO.getNotes(), new Customer(serverDTO.getCustomerId()));
	}

	public void update(Server server, Customer customer) {
		server.setIp(this.name);
		server.setDns(this.dns);
		server.setLogin(this.login);
		server.setPassword(this.password);
		server.setName(this.name);
		server.setNotes(this.notes);
		server.setCustomer(customer);
	}

}

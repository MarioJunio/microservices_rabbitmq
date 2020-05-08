package br.com.mj.model.dto;

import br.com.mj.model.Cliente;
import lombok.Data;

@Data
public class ClienteDto {
	
	private String uuid;
	private String nome;
	private String email;

	public Cliente toEntity() {
		Cliente cliente = new Cliente();
		cliente.setUuid(uuid);
		cliente.setNome(nome);
		cliente.setEmail(email);
		
		return cliente;
	}

}

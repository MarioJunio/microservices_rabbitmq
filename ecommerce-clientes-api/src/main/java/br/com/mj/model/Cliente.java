package br.com.mj.model;

import br.com.mj.model.dto.ClienteDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cliente {
	
	public Cliente(String id) {
		this.uuid = id;
	}
	
	private String uuid;
	private String nome;
	private String email;
	private Cart carrinho;
	
	public ClienteDto toDto() {
		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setUuid(uuid);
		clienteDto.setNome(nome);
		clienteDto.setEmail(email);
		
		return clienteDto;
	}
	
}

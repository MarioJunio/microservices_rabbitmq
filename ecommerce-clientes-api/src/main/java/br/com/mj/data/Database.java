package br.com.mj.data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import br.com.mj.model.Cliente;

@Component
public class Database {

	private List<Cliente> clientes = new ArrayList<>();

	public Cliente add(Cliente cliente) {
		cliente.setUuid(UUID.randomUUID().toString());
		
		clientes.add(cliente);
		
		return cliente;
	}

	public void delete(String id) {
		clientes.remove(new Cliente(id));
	}

	public Cliente get(String id) {
		return clientes.stream().filter((cliente) -> cliente.getUuid().equals(id)).findFirst().get();
	}
}

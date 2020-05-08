package br.com.mj.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import br.com.mj.model.Produto;

@Component
public class Database {

	private List<Produto> produtos = new ArrayList<>();

	public Produto add(Produto produto) {
		produto.setId(UUID.randomUUID().toString());

		this.produtos.add(produto);

		return produto;
	}

	public Optional<Produto> get(String id) {
		return this.produtos.stream().filter((produto) -> produto.getId().equals(id)).findFirst();
	}
	
	public void delete(String id) {
		this.produtos.remove(new Produto(id));
	}

}

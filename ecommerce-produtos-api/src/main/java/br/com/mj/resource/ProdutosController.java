package br.com.mj.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mj.database.Database;
import br.com.mj.model.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

	private Database database;

	@Autowired
	public ProdutosController(Database database) {
		this.database = database;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscar(@PathVariable String id) {
		Optional<Produto> optionalProduto = this.database.get(id);

		return optionalProduto.isPresent() 
				? ResponseEntity.ok(optionalProduto.get())
				: ResponseEntity.notFound().build();
	}

}

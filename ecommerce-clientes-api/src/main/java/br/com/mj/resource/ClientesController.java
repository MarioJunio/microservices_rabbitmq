package br.com.mj.resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mj.data.Database;
import br.com.mj.model.Cliente;
import br.com.mj.model.dto.ClienteDto;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

	private Database database;
	private RabbitTemplate rabbitTemplate;
	private Environment env;

	@Autowired
	public ClientesController(Database database, RabbitTemplate rabbitTemplate, Environment env) {
		this.database = database;
		this.rabbitTemplate = rabbitTemplate;
		this.env = env;
	}

	@PostMapping()
	public ResponseEntity<ClienteDto> novo(@RequestBody ClienteDto clienteDto) {
		Cliente cliente = database.add(clienteDto.toEntity());

		this.rabbitTemplate.convertAndSend(this.env.getProperty("exchange.name"),
				this.env.getProperty("exchange.routing.mail-welcome"), cliente.getUuid());

		return ResponseEntity.created(null).body(cliente.toDto());
	}

}

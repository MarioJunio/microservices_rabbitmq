package br.com.mj.resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${queue.cliente.mail.name}")
	private String clientesMailQueue;

	@Autowired
	public ClientesController(Database database, RabbitTemplate rabbitTemplate) {
		this.database = database;
		this.rabbitTemplate = rabbitTemplate;
	}

	@PostMapping()
	public ResponseEntity<ClienteDto> novo(@RequestBody ClienteDto clienteDto) {
		Cliente cliente = database.add(clienteDto.toEntity());

		this.rabbitTemplate.convertAndSend(this.clientesMailQueue, cliente.getUuid());

		return ResponseEntity.created(null).body(cliente.toDto());
	}

}

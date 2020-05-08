package br.com.mj.queues;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ClientesConsumer {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RabbitListener(queues = { "${queue.cliente.mail.name}" })
	public void receiver(@Payload String clienteUuid) {
		logger.info(String.format("Buscando cliente: %s...", clienteUuid));
		logger.info("Enviando email...");
	}

}

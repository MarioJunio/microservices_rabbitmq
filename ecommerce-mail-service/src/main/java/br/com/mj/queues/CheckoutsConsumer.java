package br.com.mj.queues;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CheckoutsConsumer {
	Logger logger = LoggerFactory.getLogger(getClass());

	@RabbitListener(queues = { "${queue.checkout.mail.name}" })
	public void receiver(@Payload String checkoutId) {
		logger.info(String.format("Checkout recebido processando pedido: %s", checkoutId));
		logger.info("Enviando email...");
	}
}

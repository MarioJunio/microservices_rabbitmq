package br.com.mj.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mj.model.dto.CheckoutDto;

@RestController
@RequestMapping("/checkouts")
public class CheckoutController {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${queue.checkout.mail.name}")
	private String queueMail;
	
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	public CheckoutController(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@PostMapping
	public void realizarCheckout(@RequestBody CheckoutDto checkoutDto) throws InterruptedException {
		logger.info("Realizando checkout " + checkoutDto.toString());
		
		// Realiza lógica do procedimento de checkout...
		Thread.sleep(1000 * 5);
		
		rabbitTemplate.convertAndSend(queueMail, checkoutDto.getPedidoId());
		
		logger.info("Checkout realizado");
		
	}
}

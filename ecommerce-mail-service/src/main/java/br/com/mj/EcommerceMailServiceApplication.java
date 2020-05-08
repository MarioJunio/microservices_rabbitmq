package br.com.mj;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class EcommerceMailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceMailServiceApplication.class, args);
	}

}

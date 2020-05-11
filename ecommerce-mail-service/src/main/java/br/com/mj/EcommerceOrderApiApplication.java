package br.com.mj;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class EcommerceOrderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceOrderApiApplication.class, args);
	}

}

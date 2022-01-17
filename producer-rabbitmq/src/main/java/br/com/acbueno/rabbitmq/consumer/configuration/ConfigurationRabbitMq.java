package br.com.acbueno.rabbitmq.consumer.configuration;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationRabbitMq {

	public static String EXCHANGE_NAME = "cars";
	
	@Bean
	public Exchange declareExchange() {
		return ExchangeBuilder.directExchange(EXCHANGE_NAME)
				.durable(true)
				.build();
	}

}

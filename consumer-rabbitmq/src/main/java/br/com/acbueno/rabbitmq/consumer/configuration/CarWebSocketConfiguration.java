package br.com.acbueno.rabbitmq.consumer.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
public class CarWebSocketConfiguration implements WebSocketMessageBrokerConfigurer {
	
	public static final String BROKER = "carCreated";
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/socket")
		.setAllowedOriginPatterns("*")
		.withSockJS();
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker(BROKER);
	}

}

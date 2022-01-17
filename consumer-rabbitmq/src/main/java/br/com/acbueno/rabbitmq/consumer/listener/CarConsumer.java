package br.com.acbueno.rabbitmq.consumer.listener;





import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import br.com.acbueno.rabbitmq.consumer.configuration.CarWebSocketConfiguration;
import br.com.acbueno.rabbitmq.consumer.configuration.ConfigurationRabbitMq;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CarConsumer {
	
	@Autowired
	private SimpMessagingTemplate  simpMessagingTemplate;
	
	@RabbitListener(queues = ConfigurationRabbitMq.QUEUE)
	public void consumer(Message message) {
		simpMessagingTemplate.convertAndSend(CarWebSocketConfiguration.BROKER, 
				new String(message.getBody()));	
	}

}

package br.com.acbueno.rabbitmq.consumer.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.acbueno.rabbitmq.consumer.configuration.ConfigurationRabbitMq;
import br.com.acbueno.rabbitmq.consumer.model.Car;
import br.com.acbueno.rabbitmq.consumer.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CarService {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public Car save(Car car) {
		Car carSaved = carRepository.save(car);
		return carSaved;
	}
	
	public void sendCarToRabbit(Car car) {
		try {
			String json = new ObjectMapper().writeValueAsString(car);
			rabbitTemplate.convertAndSend(ConfigurationRabbitMq.EXCHANGE_NAME, "", json);
			log.info(String.format("Json values: %s", json));
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
	}

}

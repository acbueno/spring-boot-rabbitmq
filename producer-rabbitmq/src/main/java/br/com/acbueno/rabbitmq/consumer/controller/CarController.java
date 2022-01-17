package br.com.acbueno.rabbitmq.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.acbueno.rabbitmq.consumer.model.Car;
import br.com.acbueno.rabbitmq.consumer.services.CarService;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/api/cars")
@Slf4j
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@PostMapping
	public ResponseEntity<Car> save(@RequestBody Car car){
		Car carSaved = carService.save(car);
		log.info(String.format("Car saved: %s", carSaved.toString()));
		carService.sendCarToRabbit(carSaved);
		return ResponseEntity.ok(carSaved);
	}

}

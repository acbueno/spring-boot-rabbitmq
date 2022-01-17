package br.com.acbueno.rabbitmq.consumer.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.com.acbueno.rabbitmq.consumer.model.Car;

@Service
@Scope("prototype")
public class CarRepository {

	private List<Car> cars;

	public CarRepository() {
		this.cars = new ArrayList<>();
	}

	public Car save(Car car) {
		cars.add(car);
		return car;
	}

}

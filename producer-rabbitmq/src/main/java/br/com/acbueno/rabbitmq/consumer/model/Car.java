package br.com.acbueno.rabbitmq.consumer.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class Car {
	
	private String brand;
	private String modelName;
	private String versionName;
	private Date  yearFactory;
	private Date yerModel;

}

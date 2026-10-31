package com.codegnan.SpringCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarMain {

	public static void main(String[] args) {
		
		ApplicationContext context=
				new AnnotationConfigApplicationContext(AppConfig.class);
		Car car=context.getBean(Car.class);
		car.drive();
	}
} 

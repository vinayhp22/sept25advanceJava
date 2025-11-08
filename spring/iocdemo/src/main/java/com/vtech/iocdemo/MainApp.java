package com.vtech.iocdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
//		Engine engine = new Engine("Petrol");
//		Car car = new Car(engine);
//		
//		System.out.println(car.toString());

		//Loading IOC container
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		//Get bean from Sping container
		Car car = (Car)context.getBean("car");
		
		//Using the car bean
		System.out.println(car.toString());
	}
}

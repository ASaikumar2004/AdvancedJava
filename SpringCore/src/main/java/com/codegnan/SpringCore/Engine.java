package com.codegnan.SpringCore;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class Engine {
	
	public void startEngine() {
		System.out.println("Engine started");
	}

}
